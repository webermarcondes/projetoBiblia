package br.com.projetobiblia.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import br.com.projetobiblia.service.Service;
import br.com.projetobiblia.view.util.TableModel;
import br.com.projetobiblia.vo.LivroVO;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.math.BigInteger;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BibliaView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldVersiculoInicial;
	private JTextField textFieldVersiculoFinal;
	private JTextField textFieldTexto;
	private JTable table;
	private TableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibliaView frame = new BibliaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	LivroVO livroSelecionado = new LivroVO();
	
	public BibliaView() {
		Service servico = new  Service();
		
		
		
		setResizable(false);
		setTitle("Consultando a Biblía");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLivro.setBounds(10, 22, 98, 15);
		contentPane.add(lblLivro);
		
		DefaultComboBoxModel<String> cbbxLivroModel = new DefaultComboBoxModel<>();
		cbbxLivroModel.addAll(servico.listarEscritores());
		
		JComboBox comboBoxNomeLivro = new JComboBox(cbbxLivroModel);
		comboBoxNomeLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livroSelecionado = servico.buscarLivroPorEscritor(comboBoxNomeLivro.getSelectedItem().toString());}}
		);
		
		
		comboBoxNomeLivro.setSelectedIndex(0);
		comboBoxNomeLivro.setBounds(62, 20, 182, 21);
		contentPane.add(comboBoxNomeLivro);
		

		JLabel lblCapitulo = new JLabel("Capítulo");
		lblCapitulo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCapitulo.setBounds(295, 24, 98, 15);
		contentPane.add(lblCapitulo);

		DefaultComboBoxModel<BigInteger> cbbxCapituloModel = new DefaultComboBoxModel<>();
		
		JComboBox comboBoxCapitulo = new JComboBox(cbbxCapituloModel);
		comboBoxCapitulo.setBounds(362, 22, 63, 21);
		contentPane.add(comboBoxCapitulo);

		JLabel lblVersiculoInicio = new JLabel("Versículo Inicial");
		lblVersiculoInicio.setFont(new Font("Arial", Font.PLAIN, 15));
		lblVersiculoInicio.setBounds(465, 23, 155, 15);
		contentPane.add(lblVersiculoInicio);

		textFieldVersiculoInicial = new JTextField();
		textFieldVersiculoInicial.setBounds(581, 22, 52, 19);
		contentPane.add(textFieldVersiculoInicial);
		textFieldVersiculoInicial.setColumns(10);

		JLabel lblVersiculoFinal = new JLabel("Versículo Inicial");
		lblVersiculoFinal.setFont(new Font("Arial", Font.PLAIN, 15));
		lblVersiculoFinal.setBounds(671, 23, 155, 15);
		contentPane.add(lblVersiculoFinal);

		textFieldVersiculoFinal = new JTextField();
		textFieldVersiculoFinal.setColumns(10);
		textFieldVersiculoFinal.setBounds(805, 22, 52, 19);
		contentPane.add(textFieldVersiculoFinal);

		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTexto.setBounds(10, 64, 98, 15);
		contentPane.add(lblTexto);

		textFieldTexto = new JTextField();
		textFieldTexto.setColumns(10);
		textFieldTexto.setBounds(62, 63, 795, 19);
		contentPane.add(textFieldTexto);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\mizak\\Downloads\\lupa-com-coracao.png"));
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		btnPesquisar.setBounds(892, 19, 149, 22);
		contentPane.add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 103, 1031, 332);
		contentPane.add(scrollPane);

		tableModel = new TableModel();
		tableModel.addColumn("Livro");
		tableModel.addColumn("Capítulo");
		tableModel.addColumn("Versículo");
		tableModel.addColumn("Texto");

		table = new JTable(tableModel);
		table.setAutoscrolls(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel tableColumnModel = table.getColumnModel();
		tableColumnModel.getColumn(0).setPreferredWidth(100);
		tableColumnModel.getColumn(1).setPreferredWidth(100);
		tableColumnModel.getColumn(2).setPreferredWidth(100);
		tableColumnModel.getColumn(3).setPreferredWidth(713);

		scrollPane.setViewportView(table);

		table.setAutoscrolls(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollPane.setViewportView(table);

		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("C:\\Users\\mizak\\Downloads\\sair.png"));
		btnSair.setFont(new Font("Arial", Font.BOLD, 12));
		btnSair.setBounds(10, 445, 109, 21);
		contentPane.add(btnSair);

	}
}
