package components;

import axoloti.PatchGUI;
import axoloti.Theme;
import axoloti.datatypes.Bool32;
import axoloti.datatypes.CharPtr32;
import axoloti.datatypes.Frac32;
import axoloti.datatypes.Frac32buffer;
import axoloti.datatypes.Int32;
import axoloti.datatypes.Int32Ptr;

public class VisibleCablePanel extends javax.swing.JPanel {

    PatchGUI p;

    public VisibleCablePanel(PatchGUI p) {
        this.p = p;
        initComponents();

        jCheckBox1.setBackground(Theme.getCurrentTheme().Cable_Frac32Buffer);
        jCheckBox1.setOpaque(true);
        jCheckBox1.setSelected(true);
        jCheckBox1.setRolloverEnabled(false);

        jCheckBox2.setBackground(Theme.getCurrentTheme().Cable_Frac32);
        jCheckBox2.setOpaque(true);
        jCheckBox2.setSelected(true);
        jCheckBox2.setRolloverEnabled(false);

        jCheckBox4.setBackground(Theme.getCurrentTheme().Cable_Int32Pointer);
        jCheckBox4.setOpaque(true);
        jCheckBox4.setSelected(true);
        jCheckBox4.setRolloverEnabled(false);

        jCheckBox5.setBackground(Theme.getCurrentTheme().Cable_CharPointer32);
        jCheckBox5.setOpaque(true);
        jCheckBox5.setSelected(true);
        jCheckBox5.setRolloverEnabled(false);

        jCheckBox6.setBackground(Theme.getCurrentTheme().Cable_Bool32);
        jCheckBox6.setOpaque(true);
        jCheckBox6.setSelected(true);
        jCheckBox6.setRolloverEnabled(false);

        jCheckBox7.setBackground(Theme.getCurrentTheme().Cable_Int32);
        jCheckBox7.setOpaque(true);
        jCheckBox7.setSelected(true);
        jCheckBox7.setRolloverEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        // buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelVisibleCables = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();

        setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jLabelVisibleCables.setText("Visible Cables");
        jLabelVisibleCables.setAlignmentX(CENTER_ALIGNMENT);
        jLabelVisibleCables.setMaximumSize(null);
        jLabelVisibleCables.setMinimumSize(null);
        jLabelVisibleCables.setPreferredSize(null);
        add(jLabelVisibleCables);

        jPanel2.setMaximumSize(null);
        jPanel2.setMinimumSize(null);
        jPanel2.setPreferredSize(null);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1);

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox2);

        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox6);

        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox7);

        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox4);

        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox5);

        add(jPanel2);
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        p.setCableTypeEnabled(Frac32buffer.d, jCheckBox1.isSelected());
        p.updateNetVisibility();
    }

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        p.setCableTypeEnabled(Frac32.d, jCheckBox2.isSelected());
        p.updateNetVisibility();
    }

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {
        p.setCableTypeEnabled(Bool32.d, jCheckBox6.isSelected());
        p.updateNetVisibility();
    }

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {
        p.setCableTypeEnabled(Int32.d, jCheckBox7.isSelected());
        p.updateNetVisibility();
    }

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        p.setCableTypeEnabled(Int32Ptr.d, jCheckBox4.isSelected());
        p.updateNetVisibility();
    }

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {
        p.setCableTypeEnabled(CharPtr32.d, jCheckBox5.isSelected());
        p.updateNetVisibility();
    }

    // private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabelVisibleCables;
    private javax.swing.JPanel jPanel2;
}
