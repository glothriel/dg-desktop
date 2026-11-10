import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public final class Main {
    public static void main(String[] args) throws Exception {
        boolean selfTest = args.length == 1 && args[0].equals("--self-test");
        SwingUtilities.invokeAndWait(() -> {
            JFrame frame = new JFrame("Operaton testing demo");
            JLabel greeting = new JLabel("Hello world", SwingConstants.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(greeting);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            if (selfTest) {
                try {
                    if (!frame.isShowing() || !greeting.isShowing()
                            || !greeting.getText().equals("Hello world")) {
                        throw new AssertionError("Expected visible Hello world GUI");
                    }
                    System.out.println("GUI self-test passed");
                } finally {
                    frame.dispose();
                }
            }
        });
    }
}
