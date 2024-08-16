/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exameni;

/**
 *
 * @author Jayma
 */
import java.awt.BorderLayout;import java.awt.Color;
import java.awt.GridLayout;import javax.swing.JButton;
import javax.swing.JFrame;import javax.swing.JOptionPane;
import javax.swing.JPanel;import javax.swing.JScrollPane;
import javax.swing.JTextArea;import javax.swing.SwingUtilities;
public class SocialApp extends JFrame {
    private UberSocial uberSocial;    private JTextArea outputArea;
    // Constructor
    public SocialApp() {        uberSocial = new UberSocial();
        setTitle("Uber Social");        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        setLayout(new BorderLayout());
        outputArea = new JTextArea();
        outputArea.setEditable(false);        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        // Botones para cada funcionalidad
        JButton addAccountBtn = new JButton("Agregar Cuenta");        addAccountBtn.addActionListener(e -> agregarCuenta());
        addAccountBtn.setBackground(Color.black);        addAccountBtn.setForeground(Color.white);
        panel.add(addAccountBtn);
        JButton addPostBtn = new JButton("Agregar Post");        addPostBtn.addActionListener(e -> agregarPost());
        addPostBtn.setBackground(Color.white);        panel.add(addPostBtn);
        JButton addFriendBtn = new JButton("Agregar Amigo");
        addFriendBtn.addActionListener(e -> agregarAmigo());        addFriendBtn.setBackground(Color.black);
        addFriendBtn.setForeground(Color.white);        panel.add(addFriendBtn);
        JButton addCommentBtn = new JButton("Agregar Comentario");
        addCommentBtn.addActionListener(e -> agregarComment());        addCommentBtn.setBackground(Color.white);
        panel.add(addCommentBtn);
        JButton viewProfileBtn = new JButton("Ver Perfil");        viewProfileBtn.addActionListener(e -> verPerfil());
        viewProfileBtn.setBackground(Color.black);        viewProfileBtn.setForeground(Color.white);
        panel.add(viewProfileBtn);
        add(panel, BorderLayout.NORTH);
        setVisible(true);    }
    private void agregarCuenta() {
        String username = JOptionPane.showInputDialog(this, "Ingrese el nombre de usuario:");        String tipo = JOptionPane.showInputDialog(this, "Ingrese el tipo de cuenta (FACEBOOK/TWITTER):");
        uberSocial.agregarCuenta(username, tipo.toUpperCase());        outputArea.append("Cuenta agregada: " + username + " (" + tipo + ")\n");
    }
    private void agregarPost() {        String username = JOptionPane.showInputDialog(this, "Ingrese el nombre de usuario:");
        String post = JOptionPane.showInputDialog(this, "Ingrese el contenido del post:");        uberSocial.agregarPost(username, post);
        outputArea.append("Post agregado por " + username + ": " + post + "\n");    }
    private void agregarAmigo() {
        String user1 = JOptionPane.showInputDialog(this, "Ingrese el nombre del primer usuario:");        String user2 = JOptionPane.showInputDialog(this, "Ingrese el nombre del segundo usuario:");
        uberSocial.agregarAmigo(user1, user2);        outputArea.append(user1 + " y " + user2 + " ahora son amigos.\n");
    }
    private void agregarComment() {        String username = JOptionPane.showInputDialog(this, "Ingrese el nombre del autor del post:");
        int postID = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del post:"));        String autor = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario que comentara:");
        String comment = JOptionPane.showInputDialog(this, "Ingrese el contenido del comentario:");        uberSocial.agregarComment(username, postID, autor, comment);
        outputArea.append("Comentario agregado por " + autor + " al post " + postID + " de " + username + ".\n");    }
    private void verPerfil() {
        String username = JOptionPane.showInputDialog(this, "Ingrese el nombre de usuario:");        outputArea.append("Perfil de " + username + ":\n");
        uberSocial.profileFrom(username);    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SocialApp::new);    }
}