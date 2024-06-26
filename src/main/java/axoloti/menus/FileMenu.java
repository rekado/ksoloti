/**
 * Copyright (C) 2013 - 2016 Johannes Taelman
 * Edited 2023 - 2024 by Ksoloti
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
package axoloti.menus;

import axoloti.FileUtils;
import axoloti.MainFrame;
import static axoloti.MainFrame.axoObjects;
import static axoloti.MainFrame.mainframe;

import axoloti.PatchFrame;
import axoloti.PatchGUI;
import axoloti.dialogs.PatchBank;
import axoloti.dialogs.PreferencesFrame;
import axoloti.utils.AxolotiLibrary;
import axoloti.utils.KeyUtils;
import axoloti.utils.Preferences;
import generatedobjects.GeneratedObjects;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import qcmds.QCmdProcessor;

/**
 *
 * @author jtaelman
 */
public class FileMenu extends JMenu {

    public FileMenu(String s) {
        super(s);
        setDelay(300);
    }

    public FileMenu() {
        super();
        setDelay(300);
    }

    public void initComponents() {

        int pos = 0;
        jMenuNewBank = new JMenuItem();
        jMenuNewPatch = new JMenuItem();
        jMenuOpen = new JMenuItem();
        jMenuOpenURL = new JMenuItem();
        jMenuQuit = new JMenuItem();
        jMenuRegenerateObjects = new JMenuItem();
        jMenuReloadObjects = new JMenuItem();
        jMenuSync = new JMenuItem();
        jSeparator1 = new JPopupMenu.Separator();
        jSeparator2 = new JPopupMenu.Separator();
        jSeparator3 = new JPopupMenu.Separator();
        libraryMenu1 = new LibraryMenu();
        recentFileMenu1 = new RecentFileMenu();
        favouriteMenu1 = new FavouriteMenu();
        jMenuItemPreferences = new JMenuItem();
        jMenuAutoTest = new JMenuItem();

        jMenuNewPatch.setMnemonic('N');
        jMenuNewPatch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                KeyUtils.CONTROL_OR_CMD_MASK));
        jMenuNewPatch.setText("New Patch");
        jMenuNewPatch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNewPatchActionPerformed(evt);
            }
        });
        insert(jMenuNewPatch, pos++);

        jMenuNewBank.setMnemonic('B');
        jMenuNewBank.setText("New Patch Bank");
        jMenuNewBank.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNewBankActionPerformed(evt);
            }
        });
        insert(jMenuNewBank, pos++);

        jMenuOpen.setMnemonic('O');
        jMenuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                KeyUtils.CONTROL_OR_CMD_MASK));
        jMenuOpen.setText("Open...");
        jMenuOpen.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenActionPerformed(evt);
            }
        });
        insert(jMenuOpen, pos++);

        jMenuOpenURL.setMnemonic('U');
        jMenuOpenURL.setText("Open from URL...");
        jMenuOpenURL.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenURLActionPerformed(evt);
            }
        });
        insert(jMenuOpenURL, pos++);

        recentFileMenu1.setMnemonic('R');
        recentFileMenu1.setText("Open Recent");
        insert(recentFileMenu1, pos++);

        libraryMenu1.setMnemonic('L');
        libraryMenu1.setText("Library");
        insert(libraryMenu1, pos++);

        favouriteMenu1.setMnemonic('V');
        favouriteMenu1.setText("Favourites");
        insert(favouriteMenu1, pos++);

        add(jSeparator1);

        jMenuSync.setMnemonic('Y');
        jMenuSync.setText("Sync Libraries");
        jMenuSync.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSyncActionPerformed(evt);
            }
        });
        insert(jMenuSync, pos++);

        jMenuReloadObjects.setMnemonic('J');
        jMenuReloadObjects.setText("Reload Objects");
        jMenuReloadObjects.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReloadObjectsActionPerformed(evt);
            }
        });
        add(jMenuReloadObjects);

        jMenuRegenerateObjects.setText("Regenerate Objects");
        jMenuRegenerateObjects.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegenerateObjectsActionPerformed(evt);
            }
        });
        add(jMenuRegenerateObjects);

        jMenuAutoTest.setText("Test Compilation");
        jMenuAutoTest.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAutoTestActionPerformed(evt);
            }
        });
        add(jMenuAutoTest);
        add(jSeparator2);

        jMenuItemPreferences.setMnemonic('P');
        jMenuItemPreferences.setText("Preferences...");
        jMenuItemPreferences.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COMMA,
                KeyUtils.CONTROL_OR_CMD_MASK));
        jMenuItemPreferences.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPreferencesActionPerformed(evt);
            }
        });
        add(jMenuItemPreferences);
        add(jSeparator3);

        jMenuQuit.setMnemonic('Q');
        jMenuQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                KeyUtils.CONTROL_OR_CMD_MASK));
        jMenuQuit.setText("Quit");
        jMenuQuit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuQuitActionPerformed(evt);
            }
        });
        add(jMenuQuit);

        jMenuRegenerateObjects.setVisible(false);
        if (!Preferences.LoadPreferences().getExpertMode()) {
            jMenuAutoTest.setVisible(false);
        }
    }

    private javax.swing.JMenuItem jMenuNewBank;
    private javax.swing.JMenuItem jMenuNewPatch;
    private javax.swing.JMenuItem jMenuOpen;
    private javax.swing.JMenuItem jMenuOpenURL;
    private javax.swing.JMenuItem jMenuQuit;
    @Deprecated
    private javax.swing.JMenuItem jMenuRegenerateObjects;
    private javax.swing.JMenuItem jMenuReloadObjects;
    private javax.swing.JMenuItem jMenuSync;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private axoloti.menus.LibraryMenu libraryMenu1;
    private axoloti.menus.RecentFileMenu recentFileMenu1;
    private axoloti.menus.FavouriteMenu favouriteMenu1;
    private javax.swing.JMenuItem jMenuItemPreferences;
    private javax.swing.JMenuItem jMenuAutoTest;

    private void jMenuItemPreferencesActionPerformed(java.awt.event.ActionEvent evt) {
        PreferencesFrame.GetPreferencesFrame().setState(java.awt.Frame.NORMAL);
        PreferencesFrame.GetPreferencesFrame().setVisible(true);
    }

    private void jMenuAutoTestActionPerformed(java.awt.event.ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(mainframe, "Running these tests will take a long time and freeze the UI with no output until complete. Do you wish to continue?") == JOptionPane.YES_OPTION) {
            mainframe.runAllTests();
        }
    }

    private void jMenuRegenerateObjectsActionPerformed(java.awt.event.ActionEvent evt) {
        GeneratedObjects.WriteAxoObjects();
        jMenuReloadObjectsActionPerformed(evt);
    }

    private void jMenuReloadObjectsActionPerformed(java.awt.event.ActionEvent evt) {
        axoObjects.LoadAxoObjects();
    }

    private void jMenuOpenURLActionPerformed(java.awt.event.ActionEvent evt) {
        OpenURL();
    }

    public void OpenURL() {
        String url = JOptionPane.showInputDialog(this, "Enter URL:");
        if (url == null) {
            return;
        }
        try {
            InputStream input = new URL(url).openStream();
            String name = url.substring(url.lastIndexOf("/") + 1, url.length());
            PatchGUI.OpenPatch(name, input);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, "Invalid URL {0}\n{1}", new Object[]{url, ex});
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, "Unable to open URL {0}\n{1}", new Object[]{url, ex});
        }
    }

    private void jMenuOpenActionPerformed(java.awt.event.ActionEvent evt) {
        FileUtils.Open((JFrame) SwingUtilities.getWindowAncestor(this));
    }

    private void jMenuNewPatchActionPerformed(java.awt.event.ActionEvent evt) {
        NewPatch();
    }

    private void jMenuSyncActionPerformed(java.awt.event.ActionEvent evt) {
        class Thd extends Thread {
            public void run() {
                Logger.getLogger(FileMenu.class.getName()).log(Level.INFO, "Syncing Libraries, please wait...");
                for (AxolotiLibrary lib : Preferences.LoadPreferences().getLibraries()) {
                    lib.sync();
                }
                Logger.getLogger(FileMenu.class.getName()).log(Level.INFO, "Finished syncing Libraries.\n");
                axoObjects.LoadAxoObjects();
            }
        }
        Thd thread = new Thd();
        thread.start();
    }

    private void jMenuNewBankActionPerformed(java.awt.event.ActionEvent evt) {
        NewBank();
    }

    public void NewPatch() {
        PatchGUI patch1 = new PatchGUI();
        PatchFrame pf = new PatchFrame(patch1, QCmdProcessor.getQCmdProcessor());
        patch1.PostContructor();
        pf.setLocation((int)pf.getLocation().getX() + 240 , (int)pf.getLocation().getY() + 160);
        patch1.setFileNamePath("untitled");
        pf.setVisible(true);
    }

    public void NewBank() {
        PatchBank b = new PatchBank();
        b.setVisible(true);
    }

    private void jMenuQuitActionPerformed(java.awt.event.ActionEvent evt) {
        mainframe.Quit();
    }

}
