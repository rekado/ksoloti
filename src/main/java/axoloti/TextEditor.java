/**
 * Copyright (C) 2013, 2014 Johannes Taelman
 *
 * This file is part of Axoloti.
 *
 * Axoloti is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Axoloti is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Axoloti. If not, see <http://www.gnu.org/licenses/>.
 */
package axoloti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.*;

/**
 *
 * @author Johannes Taelman
 */
public class TextEditor extends javax.swing.JFrame implements DocumentWindow {

    StringRef s;
    RSyntaxTextArea textArea;
    final DocumentWindow parent;

    /**
     * Creates new form TextEditor
     *
     * @param s initial string
     */
    public TextEditor(StringRef s, DocumentWindow parent) {
        initComponents();
        this.parent = parent;
        this.s = s;
        textArea = new RSyntaxTextArea(20, 60);
        // textArea.setSyntaxScheme(new SyntaxScheme(UIManager.getFont("monospaced.font"), true));
        try {
            Theme theme = Theme.load(getClass().getResourceAsStream(
                "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
            theme.apply(textArea);
        } catch (IOException ioe) { // Never happens
            ioe.printStackTrace();
        }
        textArea.setFont(UIManager.getFont("monospaced.font"));
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAntiAliasingEnabled(true);
        textArea.setMarkOccurrences(true);
        textArea.setPaintTabLines(true);
        textArea.setMarkOccurrencesColor(new Color(0x00,0x00,0x00, 0x60));
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.setLayout(new BorderLayout());
        cp.add(sp);
        textArea.setVisible(true);
        setContentPane(cp);
        textArea.setText(s.s);
        setIconImage(new ImageIcon(getClass().getResource("/resources/ksoloti_icon.png")).getImage());
    }

    public void SetText(String s) {
        textArea.setText(s);
    }

    public String GetText() {
        return textArea.getText();
    }

    public void Close() {
        parent.GetChildDocuments().remove(this);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cp = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(256, 128));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        javax.swing.GroupLayout cpLayout = new javax.swing.GroupLayout(cp);
        cp.setLayout(cpLayout);
        cpLayout.setHorizontalGroup(
            cpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );
        cpLayout.setVerticalGroup(
            cpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
//        System.out.println("txt changed (lost focus)");
//        attr.sText = jEditorPane1.getText();
        s.s = textArea.getText();
    }//GEN-LAST:event_formWindowLostFocus

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        parent.GetChildDocuments().remove(this);
    }//GEN-LAST:event_formComponentHidden

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        parent.GetChildDocuments().add(this);
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cp;
    // End of variables declaration//GEN-END:variables

    @Override
    public JFrame GetFrame() {
        return this;
    }

    @Override
    public boolean AskClose() {
        Close();
        return false; //TBC
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public ArrayList<DocumentWindow> GetChildDocuments() {
        return null;
    }
}
