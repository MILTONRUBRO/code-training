package br.com.devmos.model;

public class Book {
	
	private Long id;
    private String name;
    private int releaseYear;
    private String isbn;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", releaseYear=" + releaseYear + ", isbn=" + isbn + "]";
	}

}
