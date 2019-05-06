package fr.dauphine.sia.Parser;

public class MusicModel {

	private int  id;
	private boolean  readable;
	private boolean  explicit_lyrics;
	private int duration;
	private int rank;
	private int explicit_content_lyrics;
	private int explicit_content_cover;
	private String title;
	private String title_short;
	private String link;
	private String preview;
	private String type;
	private Artist artist;
	private Album album;
    
    public MusicModel(int id,boolean redeable,
    		String title,String title_short,
    		String link, int duration,int rank,
    		boolean explicit_lyrics,
    		int explicit_content_lyrics,
    		int explicit_content_cover, String preview,Artist artist, Album album, String type) {
    	
    	this.id=id;
    	this.readable=redeable;
    	this.title=title;
    	this.title_short=title_short;
    	this.link=link;
    	this.duration=duration;
    	this.rank=rank;
    	this.explicit_lyrics=explicit_lyrics;
    	this.explicit_content_lyrics=explicit_content_lyrics;
    	this.explicit_content_cover=explicit_content_cover;
    	this.preview=preview;
    	this.artist=artist;
    	this.album=album;
    	this.type=type;
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isReadable() {
		return readable;
	}
	
	public void setReadable(boolean readable) {
		this.readable = readable;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle_short() {
		return title_short;
	}
	
	public void setTitle_short(String title_short) {
		this.title_short = title_short;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public boolean isExplicit_lyrics() {
		return explicit_lyrics;
	}
	
	public void setExplicit_lyrics(boolean explicit_lyrics) {
		this.explicit_lyrics = explicit_lyrics;
	}
	
	public int getExplicit_content_lyrics() {
		return explicit_content_lyrics;
	}
	
	public void setExplicit_content_lyrics(int explicit_content_lyrics) {
		this.explicit_content_lyrics = explicit_content_lyrics;
	}
	
	public int getExplicit_content_cover() {
		return explicit_content_cover;
	}
	
	public void setExplicit_content_cover(int explicit_content_cover) {
		this.explicit_content_cover = explicit_content_cover;
	}
	
	public String getPreview() {
		return preview;
	}
	
	public void setPreview(String preview) {
		this.preview = preview;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public Album getAlbum() {
		return album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
    
    public void plot() {
    	
        System.out.println("=____________________________________________________=");
        System.out.println(" id: "+id+" readable: "+readable+" title: "+title);
        System.out.println("title_short: "+title_short+ " link "+link+" duration"+ "rank"+rank);
        System.out.println("explicit_lyrics: "+explicit_lyrics+" explicit_content_lyrics  "+explicit_content_lyrics);
        System.out.println("explicit_content_cover: "+explicit_content_cover+"  preview "+preview+" type "+type);
        artist.plot();
        album.plot();
        
    }
    
    @Override
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	s.append("#_____________________________________________________________\n");
    	s.append(" id: "+id+" | readable: "+readable+" | title: "+title);
    	s.append("\n title_short: "+title_short+ "\n link "+link+"\n duration"+ " | rank"+rank);
    	s.append("\n explicit_lyrics: "+explicit_lyrics+"\n explicit_content_lyrics  "+explicit_content_lyrics);
    	s.append("\n explicit_content_cover: "+explicit_content_cover+"\n  preview "+preview+"\n type "+type);
    	return s.toString();
    }
}
