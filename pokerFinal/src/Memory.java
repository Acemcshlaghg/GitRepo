
public class Memory {//summarizes the entire situation
	
	private Player player;
	private Table table;
	public Memory() {
		this(new Player(), new Table());
	}
	public Memory(Player player, Table table) {
		this.player = player;
		this.table= table;
	}

	//accessors
	public Player getPlayer() {
		return player;
	}
	public Table getTable() {
		return table;
	}
	//modifiers
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	
	
}
