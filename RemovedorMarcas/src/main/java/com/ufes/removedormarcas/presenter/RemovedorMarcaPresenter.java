/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.removedormarcas.presenter;

import com.ufes.removedormarcas.model.ProcessadorTexto;
import com.ufes.removedormarcas.model.RemovedorMarca;
import com.ufes.removedormarcas.view.RemovedorMarcaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valquíria Anacleto
 */
public class RemovedorMarcaPresenter {

    private final RemovedorMarcaView view;
  
    ProcessadorTexto processador = new ProcessadorTexto();
    private DefaultTableModel table;

    public RemovedorMarcaPresenter() {
        view = new RemovedorMarcaView();
        view.setLocationRelativeTo(view.getParent());
        view.setVisible(true);
        initListeners();
        view.gettxtTextoOriginal().setText("Lorem Ipsum is simply dummy text "
                + "of the printing and typesetting industry loke Microsoft, Facebook, "
                + "IBM, Apple. Lorem Ipsum has been"
                + " the industry's standard dummy text ever since the 1500s, when "
                + "an unknown printer took a galley of type and scrambled it to make"
                + " a type specimen book");

    }

    public void processarTexto() {
        try {
            processador.addTratador(new RemovedorMarca("Microsoft"));
            processador.addTratador(new RemovedorMarca("Facebook"));
            processador.addTratador(new RemovedorMarca("IBM"));
            processador.addTratador(new RemovedorMarca("Apple"));

            String texto = view.gettxtTextoOriginal().getText();

            view.gettxtTextoProcesssado().setText(processador.processaTexto(texto));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void initListeners() {

        view.getbtnProcessarTexto().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    view.gettxtTextoProcesssado().setText(view.gettxtTextoOriginal().getText());
                    processarTexto();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        view.getbtnAdicionar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String marcaNova = JOptionPane.showInputDialog(view, "Digite o nome de uma marca:");
                if (marcaNova != null) {
                    try {
                        Object rowData[] = new Object[1];
                        rowData[0] = marcaNova;
                        DefaultTableModel model = (DefaultTableModel) view.getTableMarcas().getModel();
                        model.addRow(rowData);

                        processador.addTratador(new RemovedorMarca(marcaNova));
                    } catch (Exception ex) {
                        Logger.getLogger(RemovedorMarcaPresenter.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        });

        view.getbtnDeletar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) view.getTableMarcas().getModel();
            
             
                try {
                    int SelectedRowIndex = view.getTableMarcas().getSelectedRow();
                  
                      Vector dados = model.getDataVector().elementAt(view.getTableMarcas().getSelectedRow());
                       String novaMarca =  model. getColumnName(SelectedRowIndex);
                         model.removeRow(SelectedRowIndex);
                    processador. RemoveTratador(new RemovedorMarca(novaMarca));

                } catch (Exception ex) {
                    Logger.getLogger(RemovedorMarcaPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }

}
