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

import axoloti.DocumentWindow;
import axoloti.Patch;
import axoloti.PatchSettings;
import axoloti.SubPatchMode;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Johannes Taelman
 */
public class PatchSettingsFrame extends javax.swing.JFrame implements DocumentWindow {

    PatchSettings settings;

    final Patch patch;

    /**
     * Creates new form PatchSettingsFrame
     *
     * @param settings settings to load/save
     */
    public PatchSettingsFrame(PatchSettings settings, Patch patch) {
        initComponents();
        this.patch = patch;
        setTitle("settings");
        setIconImage(new ImageIcon(getClass().getResource("/resources/axoloti_icon.png")).getImage());
        this.settings = settings;
        ((SpinnerNumberModel) jSpinnerMidiChannel.getModel()).setValue(settings.GetMidiChannel());
        ((SpinnerNumberModel) jSpinnerMidiChannel.getModel()).setMinimum(1);
        ((SpinnerNumberModel) jSpinnerMidiChannel.getModel()).setMaximum(16);
        ((SpinnerNumberModel) jSpinnerNumPresets.getModel()).setValue(settings.GetNPresets());
        ((SpinnerNumberModel) jSpinnerNumPresets.getModel()).setMinimum(0);
        ((SpinnerNumberModel) jSpinnerNumPresets.getModel()).setMaximum(64);
        ((SpinnerNumberModel) jSpinnerPresetEntries.getModel()).setValue(settings.GetNPresetEntries());
        ((SpinnerNumberModel) jSpinnerPresetEntries.getModel()).setMinimum(0);
        ((SpinnerNumberModel) jSpinnerPresetEntries.getModel()).setMaximum(64);
        ((SpinnerNumberModel) jSpinnerModulationSources.getModel()).setValue(settings.GetNModulationSources());
        ((SpinnerNumberModel) jSpinnerModulationSources.getModel()).setMinimum(0);
        ((SpinnerNumberModel) jSpinnerModulationSources.getModel()).setMaximum(64);
        ((SpinnerNumberModel) jSpinnerModulationTargets.getModel()).setValue(settings.GetNModulationTargetsPerSource());
        ((SpinnerNumberModel) jSpinnerModulationTargets.getModel()).setMinimum(0);
        ((SpinnerNumberModel) jSpinnerModulationTargets.getModel()).setMaximum(64);
        jTextFieldAuthor.setText(settings.getAuthor());
        jComboBoxLicense.setSelectedItem(settings.getLicense());
        jTextFieldAttributions.setText(settings.getAttributions());
        switch (settings.subpatchmode) {
            case no:
                jComboBoxMode.setSelectedIndex(0);
                break;
            case normal:
                jComboBoxMode.setSelectedIndex(1);
                break;
            case normalBypass:
                jComboBoxMode.setSelectedIndex(2);
                break;
            case polyphonic:
                jComboBoxMode.setSelectedIndex(3);
                break;
            case polychannel:
                jComboBoxMode.setSelectedIndex(4);
                break;
            case polyexpression:
                jComboBoxMode.setSelectedIndex(5);
                break;
        }
        jCheckBoxHasChannelAttrib.setSelected(settings.GetMidiSelector());
        jCheckBoxSaturate.setSelected(settings.getSaturate());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinnerMidiChannel = new javax.swing.JSpinner();
        jSpinnerNumPresets = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMode = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerPresetEntries = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerModulationSources = new javax.swing.JSpinner();
        jSpinnerModulationTargets = new javax.swing.JSpinner();
        jCheckBoxHasChannelAttrib = new javax.swing.JCheckBox();
        jTextFieldAuthor = new javax.swing.JTextField();
        jComboBoxLicense = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBoxSaturate = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAttributions = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("MIDI Channel");

        jSpinnerMidiChannel.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        jSpinnerMidiChannel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerMidiChannelStateChanged(evt);
            }
        });

        jSpinnerNumPresets.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        jSpinnerNumPresets.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerNumPresetsStateChanged(evt);
            }
        });

        jLabel2.setText("Subpatch mode");

        jComboBoxMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Mono", "Mono with bypass", "Polyphonic", "Polyphonic Multichannel", "Polyphonic Expression" }));
        jComboBoxMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeActionPerformed(evt);
            }
        });

        jLabel3.setText("Mono with bypass not implemented");

        jLabel4.setText("Number of presets");

        jLabel5.setText("Entries per preset");

        jSpinnerPresetEntries.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        jSpinnerPresetEntries.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPresetEntriesStateChanged(evt);
            }
        });

        jLabel6.setText("Maximum number of modulation sources");

        jLabel7.setText("Maximum number of modulation targets");

        jSpinnerModulationSources.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        jSpinnerModulationSources.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerModulationSourcesStateChanged(evt);
            }
        });

        jSpinnerModulationTargets.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        jSpinnerModulationTargets.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerModulationTargetsStateChanged(evt);
            }
        });

        jCheckBoxHasChannelAttrib.setText("Has MIDI selector");
        jCheckBoxHasChannelAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHasChannelAttribActionPerformed(evt);
            }
        });

        jTextFieldAuthor.setText("jTextField1");
        jTextFieldAuthor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAuthorFocusLost(evt);
            }
        });

        jComboBoxLicense.setEditable(true);
        jComboBoxLicense.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "undefined", "CC0", "CC BY 3.0", "CC BY SA 3.0", "GPL", "LGPL", "Confidential", "Secret", "Top secret", " " }));
        jComboBoxLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLicenseActionPerformed(evt);
            }
        });

        jLabel8.setText("Author");

        jLabel9.setText("License");

        jCheckBoxSaturate.setText("Saturate audio output");
        jCheckBoxSaturate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSaturateActionPerformed(evt);
            }
        });

        jLabel10.setText("Attributions");

        jTextFieldAttributions.setText("jTextField1");
        jTextFieldAttributions.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAttributionsFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jCheckBoxSaturate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jComboBoxLicense, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMode, 0, 1, Short.MAX_VALUE)
                            .addComponent(jCheckBoxHasChannelAttrib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jTextFieldAttributions, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jSpinnerModulationSources, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinnerMidiChannel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinnerNumPresets, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinnerPresetEntries, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jSpinnerModulationTargets, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAttributions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerMidiChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerNumPresets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerPresetEntries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jSpinnerModulationSources, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerModulationTargets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxHasChannelAttrib)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSaturate))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinnerMidiChannelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerMidiChannelStateChanged
        SpinnerModel nModel = jSpinnerMidiChannel.getModel();
        if (nModel instanceof SpinnerNumberModel) {
            settings.SetMidiChannel(((SpinnerNumberModel) nModel).getNumber().intValue());
        }
    }//GEN-LAST:event_jSpinnerMidiChannelStateChanged

    private void jComboBoxModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeActionPerformed
        switch (jComboBoxMode.getSelectedIndex()) {
            case 0:
                settings.subpatchmode = SubPatchMode.no;
                break;
            case 1:
                settings.subpatchmode = SubPatchMode.normal;
                break;
            case 2:
                settings.subpatchmode = SubPatchMode.normalBypass;
                break;
            case 3:
                settings.subpatchmode = SubPatchMode.polyphonic;
                break;
            case 4:
                settings.subpatchmode = SubPatchMode.polychannel;
                break;
            case 5:
                settings.subpatchmode = SubPatchMode.polyexpression;
                break;
            default:
                Logger.getLogger(PatchSettingsFrame.class.getName()).severe("Undefined subpatch mode");
        }
    }//GEN-LAST:event_jComboBoxModeActionPerformed

    private void jSpinnerNumPresetsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerNumPresetsStateChanged
        SpinnerModel nModel = jSpinnerNumPresets.getModel();
        if (nModel instanceof SpinnerNumberModel) {
            settings.SetNPresets(((SpinnerNumberModel) nModel).getNumber().intValue());
        }
    }//GEN-LAST:event_jSpinnerNumPresetsStateChanged

    private void jSpinnerPresetEntriesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPresetEntriesStateChanged
        SpinnerModel nModel = jSpinnerPresetEntries.getModel();
        if (nModel instanceof SpinnerNumberModel) {
            settings.SetNPresetEntries(((SpinnerNumberModel) nModel).getNumber().intValue());
        }
    }//GEN-LAST:event_jSpinnerPresetEntriesStateChanged

    private void jSpinnerModulationSourcesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerModulationSourcesStateChanged
        SpinnerModel nModel = jSpinnerModulationSources.getModel();
        if (nModel instanceof SpinnerNumberModel) {
            settings.SetNModulationSources(((SpinnerNumberModel) nModel).getNumber().intValue());
        }
    }//GEN-LAST:event_jSpinnerModulationSourcesStateChanged

    private void jSpinnerModulationTargetsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerModulationTargetsStateChanged
        SpinnerModel nModel = jSpinnerModulationTargets.getModel();
        if (nModel instanceof SpinnerNumberModel) {
            settings.SetNModulationTargetsPerSource(((SpinnerNumberModel) nModel).getNumber().intValue());
        }
    }//GEN-LAST:event_jSpinnerModulationTargetsStateChanged

    private void jCheckBoxHasChannelAttribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxHasChannelAttribActionPerformed
        settings.SetMidiSelector(jCheckBoxHasChannelAttrib.isSelected());
    }//GEN-LAST:event_jCheckBoxHasChannelAttribActionPerformed

    private void jComboBoxLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLicenseActionPerformed
        if (jComboBoxLicense.getSelectedItem() != null) {
            settings.setLicense(jComboBoxLicense.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboBoxLicenseActionPerformed

    private void jTextFieldAuthorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAuthorFocusLost
        settings.setAuthor(jTextFieldAuthor.getText());
    }//GEN-LAST:event_jTextFieldAuthorFocusLost

    private void jCheckBoxSaturateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSaturateActionPerformed
        settings.setSaturate(jCheckBoxSaturate.isSelected());
    }//GEN-LAST:event_jCheckBoxSaturateActionPerformed

    private void jTextFieldAttributionsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAttributionsFocusLost
        settings.setAttributions(jTextFieldAttributions.getText());
    }//GEN-LAST:event_jTextFieldAttributionsFocusLost

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        patch.getPatchframe().GetChildDocuments().remove(this);
    }//GEN-LAST:event_formComponentHidden

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        patch.getPatchframe().GetChildDocuments().add(this);
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxHasChannelAttrib;
    private javax.swing.JCheckBox jCheckBoxSaturate;
    private javax.swing.JComboBox jComboBoxLicense;
    private javax.swing.JComboBox jComboBoxMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinnerMidiChannel;
    private javax.swing.JSpinner jSpinnerModulationSources;
    private javax.swing.JSpinner jSpinnerModulationTargets;
    private javax.swing.JSpinner jSpinnerNumPresets;
    private javax.swing.JSpinner jSpinnerPresetEntries;
    private javax.swing.JTextField jTextFieldAttributions;
    private javax.swing.JTextField jTextFieldAuthor;
    // End of variables declaration//GEN-END:variables

    @Override
    public JFrame GetFrame() {
        return this;
    }

    @Override
    public boolean AskClose() {
        return false;
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
