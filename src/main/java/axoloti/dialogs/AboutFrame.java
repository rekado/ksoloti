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
package axoloti.dialogs;

import axoloti.Version;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author Johannes Taelman
 */
public class AboutFrame extends javax.swing.JFrame {

    public static AboutFrame aboutFrame = new AboutFrame();

    /**
     * Creates new form AboutFrame
     */
    public AboutFrame() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/resources/ksoloti_icon.png")).getImage());
        try {
            jTextPaneAboutHtml.setPage(getClass().getResource("/resources/about.html"));
        } catch (IOException ex) {
            Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        jVersionTxt.setText(Version.AXOLOTI_VERSION);
        jDateTxt.setText(Version.AXOLOTI_BUILD_TIME);
        jJavaVersion.setText(System.getProperty("java.version"));
        jTextPaneAboutHtml.setOpaque(false);

        jTextPaneAboutHtml.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    System.out.println(hle.getURL());
                    Desktop desktop = Desktop.getDesktop();
                    if (hle.getURL().getProtocol().equals("file")) {
                        // hack for relative paths
                        String path = hle.getURL().getPath();
                        File f = new File(path);
                        try {
                            desktop.browse(f.toURI());
                        } catch (IOException ex) {
                            Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            desktop.browse(hle.getURL().toURI());
                        } catch (IOException ex) {
                            Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (URISyntaxException ex) {
                            Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneAboutHtml = new javax.swing.JScrollPane();
        jTextPaneAboutHtml = new javax.swing.JTextPane();
        jLabelBuildVersion = new javax.swing.JLabel();
        jVersionTxt = new javax.swing.JLabel();
        jLabelBuildDate = new javax.swing.JLabel();
        jDateTxt = new javax.swing.JLabel();
        jLabelJavaVersion = new javax.swing.JLabel();
        jJavaVersion = new javax.swing.JLabel();

        setTitle("About Axoloti");

        jTextPaneAboutHtml.setEditable(false);
        jTextPaneAboutHtml.setContentType("text/html"); // NOI18N
        jTextPaneAboutHtml.setText("");
        jTextPaneAboutHtml.setRequestFocusEnabled(false);
        jScrollPaneAboutHtml.setViewportView(jTextPaneAboutHtml);

        jLabelBuildVersion.setText("Build Version:");
        jVersionTxt.setText("test");
        jLabelBuildDate.setText("Build Date:");
        jDateTxt.setText("test");
        jLabelJavaVersion.setText("Java Version:");
        jJavaVersion.setText("test");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneAboutHtml, javax.swing.GroupLayout.Alignment.TRAILING)

            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBuildVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jVersionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))

                    .addGroup(layout.createSequentialGroup()

                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBuildDate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelJavaVersion)
                        )
                        .addGap(18, 18, 18)

                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jJavaVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                    )
                )
            )
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()
                .addContainerGap()

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBuildVersion)
                    .addComponent(jVersionTxt)
                )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBuildDate)
                    .addComponent(jDateTxt)
                )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jJavaVersion)
                    .addComponent(jLabelJavaVersion)
                )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAboutHtml, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap()
            )
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jDateTxt;
    private javax.swing.JLabel jJavaVersion;
    private javax.swing.JLabel jLabelBuildVersion;
    private javax.swing.JLabel jLabelBuildDate;
    private javax.swing.JLabel jLabelJavaVersion;
    private javax.swing.JScrollPane jScrollPaneAboutHtml;
    private javax.swing.JTextPane jTextPaneAboutHtml;
    private javax.swing.JLabel jVersionTxt;
    // End of variables declaration//GEN-END:variables
}
