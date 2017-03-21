package br.com.fiap.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.axis2.AxisFault;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.ibm.icu.text.SimpleDateFormat;

import br.com.fiap.bo.ClienteBOStub;
import br.com.fiap.bo.ClienteBOStub.Buscar;
import br.com.fiap.bo.ClienteBOStub.BuscarResponse;
import br.com.fiap.bo.ClienteBOStub.Cadastrar;
import br.com.fiap.bo.ClienteBOStub.Cliente;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtEmail;
	private Text txtCod;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label text = new Label(shell, SWT.NONE);
		text.setBounds(10, 10, 55, 15);
		text.setText("Nome");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(10, 36, 140, 21);
		
		Label text_1 = new Label(shell, SWT.NONE);
		text_1.setBounds(10, 76, 119, 15);
		text_1.setText("Data de Nascimento");
		
		Label text_2 = new Label(shell, SWT.NONE);
		text_2.setBounds(10, 144, 55, 15);
		text_2.setText("Email");
		
		txtEmail = new Text(shell, SWT.BORDER);
		txtEmail.setBounds(10, 165, 140, 21);
		
		DateTime dtTime = new DateTime(shell, SWT.BORDER);
		dtTime.setBounds(10, 97, 80, 24);

		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nome = txtNome.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
//				Calendar data = Calendar.getInstance();
//				try {
//					data.setTime(sdf.parse(txtData.getText()));
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				}
				
				Calendar data2 = new GregorianCalendar(dtTime.getYear(), 
						dtTime.getMonth(), dtTime.getDay());
				
				String email = txtEmail.getText();
				
				try {
					ClienteBOStub stub = new ClienteBOStub();
					
					//Cadastro de cliente
					Cadastrar cadastro = new Cadastrar();
					Cliente cliente = new Cliente();
					cliente.setNome(nome);
					cliente.setDataNascimento(data2);
					cliente.setEmail(email);
					cadastro.setCliente(cliente);
					stub.cadastrar(cadastro);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				MessageDialog.openInformation(shell, "Confirmação", 
						"Cliente Cadastrado!");
				
				
			}
		});
		btnCadastrar.setBounds(10, 204, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(223, 10, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		txtCod = new Text(shell, SWT.BORDER);
		txtCod.setBounds(220, 36, 76, 21);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(193, 97, 231, 102);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableItem tblNome = new TableItem(table, SWT.NONE);
		tblNome.setText("Nome");
		
		
		TableItem tblData = new TableItem(table, SWT.NONE);
		tblData.setText("Data");
		
		
		TableItem tblEmail = new TableItem(table, SWT.NONE);
		tblEmail.setText("Email");
		
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int codigo = Integer.parseInt(txtCod.getText());
				try {
					ClienteBOStub stub = new ClienteBOStub();
					Buscar busca = new Buscar();
					busca.setCodigo(codigo);
					BuscarResponse resp = stub.buscar(busca);
					Cliente cliente = resp.get_return();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					tblNome.setText(cliente.getNome());
					tblData.setText(sdf.format(cliente.getDataNascimento().getTime())+"");
					tblEmail.setText(cliente.getEmail());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBuscar.setBounds(330, 34, 75, 25);
		btnBuscar.setText("Buscar");
		
		
		
	
	}
}
