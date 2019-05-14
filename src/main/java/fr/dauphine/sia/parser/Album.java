package fr.dauphine.sia.parser;

public class Album {

	private int  id;
    private String title;
    private String cover;
    private String cover_small;
    private String cover_medium;
    private String cover_big;
    private String cover_xl;
    private String tracklist;
    private String type;
    
    public Album(int id, String title,
    		String cover, String cover_small, String cover_medium,
    		String cover_big,String cover_xl, String tracklist ,String type ) {
    	
    	this.id=id;
    	this.title=title;
    	this.cover=cover;
    	this.cover_small=cover_small;
    	this.cover_medium=cover_medium;
    	this.cover_big=cover_big;
    	this.cover_xl=cover_xl;
    	this.tracklist=tracklist;
    	this.type=type;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCover_small() {
		return cover_small;
	}

	public void setCover_small(String cover_small) {
		this.cover_small = cover_small;
	}

	public String getCover_medium() {
		return cover_medium;
	}

	public void setCover_medium(String cover_medium) {
		this.cover_medium = cover_medium;
	}

	public String getCover_big() {
		return cover_big;
	}

	public void setCover_big(String cover_big) {
		this.cover_big = cover_big;
	}

	public String getCover_xl() {
		return cover_xl;
	}

	public void setCover_xl(String cover_xl) {
		this.cover_xl = cover_xl;
	}

	public String getTracklist() {
		return tracklist;
	}

	public void setTracklist(String tracklist) {
		this.tracklist = tracklist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
	public void plot() {
		System.out.println("*******************************************************");
		System.out.println("                   Album                                 ");
		System.out.println("id: "+id+" title: "+title+"  cover: "+cover+"  cover_small:"+cover_small);
		System.out.println("cover_medium: "+ cover_medium+" cover_big: "+cover_big+" cover_xl: "+cover_xl);
		System.out.println("tracklist: "+tracklist+" type: "+type);
		System.out.println("*******************************************************");
	}
}
