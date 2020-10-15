package items;

public class BookItem {
    private Integer id;
    private String title;
    private String desc;
    private String img;
    private Integer price;

    public BookItem() {
    }

    public BookItem(Integer id, String title, String desc, Integer price, String img) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.price = price;
    }

    public BookItem(String title, String desc, Integer price, String img) {

        this.title = title;
        this.desc = desc;
        this.img = img;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public Integer getPrice() {
        return price;
    }
}
