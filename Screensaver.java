import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Screensaver extends JFrame implements ActionListener, MouseListener, KeyListener {

    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private Timer timer;
    private int currentFrame = 0;
    private String[] frames = {

        "                      ,dlc:;.           \n" +
        "                     .,;lkOx,           \n" +
        "                     .,,cxkd'           \n" +
        "                     ,c;cccl'           \n" +
        "                   ..',:ol;.            \n" +
        "                  .....,lko.            \n" +
        "                '::'..,,;dxl.           \n" +
        "             .';:;,'..,:;:dxl:,.....    \n" +
        "             ,c,:c:,..,::;:odddoooddl.  \n" +
        "              .;:oc,'':llclddd:',,cko.  \n" +
        "               ';::,,:dkdl:,,,.   .,.   \n" +
        "               ':',;:oOOdo:..           \n" +
        "               :d,,:clddk00Odc,         \n" +
        "               ,l,;:ccc:coxk00Od:,      \n" +
        "              .;;;:ccc;.,::cldxxd,     \n" +
        "             .:;,::ccc,   ,:;;;cdd'     \n" +
        "        ..,,,cc;;::;,.       .,lxd'     \n" +
        " ..,c:,;ccclooc::c,          .,:od,     \n" +
        ":dxoc:;;;;;;:cc;'.           ';,co'     \n" +
        "ldoc:;''',.....              .',cd,     \n" +
        "lll;.                         .;cxd,..  \n" +
        "cl;.                          .:;cddddl.\n" +
        "::..                            .,,,,,,' \n" +
        "                                \n" +
        "                                \n" +
        "                                \n",
        "                      .'cxc.            \n" +
        "                      .:cdOo'           \n" +
        "                     .,';dOxo'          \n" +
        "                      ';:ccll.          \n" +
        "                   .lc;:oo;'.           \n" +
        "                  ':;,';dkl.            \n" +
        "                  ',..',dko;            \n" +
        "                ';;'..',lkoo'           \n" +
        "               .:::,..,,:oxxo:,....     \n" +
        "               .:co:.':cc:cloddddodc.   \n" +
        "                ,:;;,:dkdl:'',:llooc.   \n" +
        "                ':,;:oOOoo'    ....     \n" +
        "                .;';:lxkxko,            \n" +
        "                .;',:codk00ko.          \n" +
        "   .::cc,...   .::,;::cl:;:cdkko.       \n" +
        "  ,cddxollll:;lxd:,;:clc'',;:cdd,       \n" +
        ".:oc:,;lc:;;:ccodl::cco'   .:cxd'       \n" +
        ",d:.. ......'',;;::ccl;    .;:dd'       \n" +
        " .             ..;,,,;.    ':;co;       \n" +
        "                           .:::od,      \n" +
        "                            'c:ox;      \n" +
        "                            .::lxdc,.   \n" +
        "                            .cccloddx,  \n" +
        "                              ........  \n",
        "                       .''''.           \n" +
        "                      .:clxx:           \n" +
        "                      .;,lOOd'          \n" +
        "                      .;,cllo'          \n" +
        "                    .';:ll:::.          \n" +
        "                   .c;':xxo,            \n" +
        "                  .''.,dOxo;            \n" +
        "                  ,,..;xxoll'           \n" +
        "                 ;:'..:xxlcl'           \n" +
        "                .:;'.';cddd:.           \n" +
        "                 .;,,;llcldxo:,.        \n" +
        "                .;;;:oOOo;:lddxxl.      \n" +
        "                .;',:lOOd;.':looo'      \n" +
        "                .,'',;okkx:  ',,'.      \n" +
        "         ....    .,'.,:oxkkc.           \n" +
        "       ,ldxkxl;'..,;'',cokOk:           \n" +
        "     .clccccc::cllool:;:lldkx;          \n" +
        "    .;,'.....,:c;::llllclccodx;         \n" +
        "              ...'.,;;::cccol:.         \n" +
        "                    ..';::odo'          \n" +
        "                       'c;clo'          \n" +
        "                       'c;:lc.          \n" +
        "                       'l:cd,           \n" +
        "                       'lcoxo,          \n" +
        "                       'lccoddl:.       \n" +
        "                       ,ollloooc.       \n",
        "                        .''.            \n" +
        "                      .;,lxo,           \n" +
        "                      .,,lOOx'          \n" +
        "                      .;,:ooo'          \n" +
        "                   .'';:cl:,:.          \n" +
        "                   'l:;oxol'            \n" +
        "                  .,,:dkdoo;            \n" +
        "                  'cldxlclll'           \n" +
        "                .ccokko:ccc:.           \n" +
        "                .;::coxoccl'            \n" +
        "                 .;,';lxolx;            \n" +
        "                .;;;:codddoc:,          \n" +
        "                .;',:lkkddoclo:.        \n" +
        "             ..  .,'..';coxx:           \n" +
        "        .;cc:,..,'.,;lkkxo'           \n" +
        "    .c:cl:;,,'..,;::cxdoxc.           \n" +
        "   .:cc::c;:;,,;:c;:ccoo;            \n" +
        "  .:;..;cxdlc::cl:,coo'             \n" +
        "   ';;,,;oocoxk:,;coo'              \n" +
        "      .,;:ldkOkc,'',               \n" +
        "    ..,:oxk0kc.                 \n" +
        "    .:lddxxkdlc'.               \n" +
        "                               \n" +
        "                               \n"
    };

    public Screensaver() {
        // Set up the JFrame
        setTitle("Screensaver");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
       
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Create and configure the JTextArea
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20)); // Increase font size here
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setText(frames[currentFrame]);

        // Add the JTextArea to the JFrame
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Set up the Timer
        timer = new Timer(500, this);
        timer.start();

        // Add MouseListener and KeyListener
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame = (currentFrame + 1) % frames.length;
        textArea.setText(frames[currentFrame]);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Screensaver saver = new Screensaver();
            saver.setVisible(true);
        });
    }
}
