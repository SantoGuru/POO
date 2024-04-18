package AV2;
import java.util.List;
import java.util.ArrayList;

public class Frigobar {
	public List<Item> itens = new ArrayList<Item>();
	
	public void addItem(Item item) {
		itens.add(item);
	}
	
	public int getItem(String nome) {
			for(int i = 0;i<itens.size();i++){
				if ((itens.get(i).nome==nome) && (itens.get(i).quantidade>0)){
						return i;
				};
			}
			return -1;
	};
}
