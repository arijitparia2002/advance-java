import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JFrame {
    private String currentUser;
    private Integer highScore;
    private Connection connection;
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;
    private JButton logoutButton;
    private JButton startButton;
    private JPanel gamePanel;
    private Timer timer;
    private ArrayList<Point> snake;
    private Point food;
    private int direction;
    private boolean running;
    private int score;
    private int delay;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int UNIT_SIZE = 20;
    private static final int INITIAL_DELAY = 100;
    private static final int SPEED_INCREASE = 2;

    public SnakeGame() {
        super("Snake Game");

        // Connect to MySQL database
        connectToDatabase();

        // Create components
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signupButton = new JButton("Sign Up");
        logoutButton = new JButton("Logout");
        startButton = new JButton("Start");
        logoutButton.setEnabled(false);
        startButton.setEnabled(false);

        // Set colors for buttons
        startButton.setBackground(Color.GREEN);
        logoutButton.setBackground(Color.RED);

        // Set font sizes for text components
        Font textFont = new Font("Arial", Font.PLAIN, 14);
        usernameField.setFont(textFont);
        passwordField.setFont(textFont);
        loginButton.setFont(textFont);
        signupButton.setFont(textFont);
        logoutButton.setFont(textFont);
        startButton.setFont(textFont);

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(SnakeGame.this, "Login successful!");
                    welcomeLabel.setText("Welcome, " + currentUser + "!");
                    startButton.setEnabled(true);
                    loginButton.setEnabled(false);
                    signupButton.setEnabled(false);
                    logoutButton.setEnabled(true);
                    usernameField.setEnabled(false);
                    passwordField.setEnabled(false);
                } else {
                    usernameField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(SnakeGame.this, "Invalid username or password.");
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(SnakeGame.this, "Username and password cannot be empty.");
                } else {
                    addUser(username, password);
                    JOptionPane.showMessageDialog(SnakeGame.this, "User created successfully!");
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                loginButton.setEnabled(true);
                signupButton.setEnabled(true);
                logoutButton.setEnabled(false);
                stopGame();
                welcomeLabel.setText("Welcome, user!");
                usernameField.setText("");
                passwordField.setText("");
                usernameField.setEnabled(true);
                passwordField.setEnabled(true);
                usernameField.requestFocus();
            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // Layout components
        addLoginComponents();
        setSize(WIDTH, HEIGHT); // Set login screen size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakegamedb", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.");
            System.exit(1);
        }
    }

    private boolean authenticate(String username, String password) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            // user is authenticated so set the current user and high score

            if (resultSet.next()) {
                currentUser = username;
                highScore = resultSet.getInt("score");
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void addUser(String username, String password) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addLoginComponents() {
        JPanel panel = new JPanel(null);

        welcomeLabel = new JLabel("Welcome," + (currentUser != null ? currentUser : "User") + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setBounds(300, 50, 200, 30);
        panel.add(welcomeLabel);

        // Positioning the Username Label and Field
        usernameLabel.setBounds(300, 100, 200, 30); // x, y, width, height
        usernameField.setBounds(300, 130, 200, 30);

        // Positioning the Password Label and Field
        passwordLabel.setBounds(300, 170, 200, 30);
        passwordField.setBounds(300, 200, 200, 30);

        // Positioning the Buttons
        loginButton.setBounds(220, 240, 100, 50);
        signupButton.setBounds(330, 240, 100, 50);
        logoutButton.setBounds(440, 240, 100, 50);
        startButton.setBounds(300, 300, 200, 50);

        // Adding components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);
        panel.add(logoutButton);
        panel.add(startButton);

        // Add leaderboard panel below the start button
        JPanel leaderboardPanel = new JPanel(new BorderLayout());
        leaderboardPanel.setBounds(50, 360, 700, 400);
        leaderboardPanel.setBorder(BorderFactory.createTitledBorder("Leaderboard"));

        // Create the table model and table
        String[] columnNames = { "Username", "Score" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable leaderboardTable = new JTable(tableModel);
        leaderboardTable.setPreferredScrollableViewportSize(new Dimension(650, 350));

        // Scrollable area for the leaderboard
        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        leaderboardPanel.add(scrollPane);

        panel.add(leaderboardPanel);

        getContentPane().add(panel);

        // Update leaderboard data
        updateLeaderboard(tableModel);
    }

    private void updateLeaderboard(DefaultTableModel tableModel) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT username, score FROM users ORDER BY score DESC");
            ResultSet resultSet = statement.executeQuery();
            tableModel.setRowCount(0); // Clear previous data

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int score = resultSet.getInt("score");
                Object[] row = { username, score };
                tableModel.addRow(row); // Add a row with user data
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void startGame() {
        getContentPane().removeAll();
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        getContentPane().add(gamePanel);
        pack();

        // Initialize game state
        snake = new ArrayList<>();
        snake.add(new Point(WIDTH / 2, HEIGHT / 2));
        generateFood();
        direction = KeyEvent.VK_RIGHT;
        running = true;
        score = 0;
        delay = INITIAL_DELAY;

        // Start timer for game loop
        timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    move();
                    checkCollision();
                    gamePanel.repaint();
                }
            }
        });
        timer.start();

        // Add key listener for controlling the snake
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        gamePanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP
                        || key == KeyEvent.VK_DOWN)
                        && (key + direction) % 2 != 0) {
                    direction = key;
                }
            }
        });
    }

    private void stopGame() {
        if (timer != null) {
            timer.stop();
        }
    }

    private void move() {
        Point head = snake.get(0);
        Point newHead = new Point(head.x, head.y);
        switch (direction) {
            case KeyEvent.VK_LEFT:
                newHead.x -= UNIT_SIZE;
                break;
            case KeyEvent.VK_RIGHT:
                newHead.x += UNIT_SIZE;
                break;
            case KeyEvent.VK_UP:
                newHead.y -= UNIT_SIZE;
                break;
            case KeyEvent.VK_DOWN:
                newHead.y += UNIT_SIZE;
                break;
        }
        snake.add(0, newHead);
        if (!newHead.equals(food)) {
            snake.remove(snake.size() - 1);
        } else {
            generateFood();
            score += 10;
            delay -= SPEED_INCREASE;
            timer.setDelay(delay);
        }
    }

    private void generateFood() {
        Random random = new Random();
        int foodX = random.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int foodY = random.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        food = new Point(foodX, foodY);
    }

    private void checkCollision() {
        Point head = snake.get(0);
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            gameOver();
        }
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        running = false;
        stopGame();
        JOptionPane.showMessageDialog(this, "Game Over! Score: " + score);
        String username = usernameField.getText();
        // Update user score in the database
        try {
            if (score > highScore) {
                highScore = score;
                PreparedStatement statement = connection.prepareStatement("UPDATE users SET score=? WHERE username=?");
                statement.setInt(1, score);
                statement.setString(2, username);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getContentPane().removeAll();
        addLoginComponents();
        revalidate();
        repaint();
        delay = INITIAL_DELAY; // Reset delay to initial value
    }

    private void draw(Graphics g) {
        // Draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw snake
        g.setColor(Color.GREEN);
        for (Point point : snake) {
            g.fillRect(point.x, point.y, UNIT_SIZE, UNIT_SIZE);
        }

        // Draw food
        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, UNIT_SIZE, UNIT_SIZE);

        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 10, 20);

        // Draw username and high score
        g.drawString("Username: " + currentUser, 10, 40);
        g.drawString("Your High Score: " + (highScore > score ? highScore : score), 10, 60);
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.setVisible(true);
    }
}
