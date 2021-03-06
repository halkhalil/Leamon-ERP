package leamon.erp.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import leamon.erp.ui.LeamonERP;
import leamon.erp.util.LeamonERPConstants;

/**
 * @Copyright Leamon India
 * @date JULY 19,2017 
 * @author Manish Kumar Mishra
 *
 */
public class MouseClickHandler implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		/* Double Click event */
		if(e.getClickCount() == 2 && !e.isConsumed()){
			e.consume();
			
			if(e.getSource() instanceof JTable){
				JTable table = (JTable)e.getSource();
				if(table.getName().equals(LeamonERPConstants.TABLE_STOCK_ITEMS)){
					/*Stock Items Table*/
					LeamonERP.stockItemList.getBtnView().doClick();
				}else if(table.getName().equals(LeamonERPConstants.TABLE_ACCOUNT_INFO_LIST)){
					LeamonERP.accountListManager.getBtnView().doClick();;
				}else if (table.getName().equals(LeamonERPConstants.TABLE_PAYMENT)){
					/*payment ui - open invoice*/
					LeamonERP.paymentUI.openInvoice("View");
				}
			}
		}else{
			//Single click
			if(e.getSource() instanceof JTable){
				JTable table = (JTable)e.getSource();
				if(table.getName().equals(LeamonERPConstants.TABLE_STOCK_ITEMS)){
					KeyListenerHandler keyListenerHandler = new KeyListenerHandler();
					keyListenerHandler.stockImageDisplayer(table);
				}
			}
		}//end else
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
