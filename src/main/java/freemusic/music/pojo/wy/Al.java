package freemusic.music.pojo.wy;
import java.util.List;
public class Al {
    private int id;

    private String name;

    private String pic_str;

    private int pic;

    private List<String> alia ;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPic_str(String pic_str){
        this.pic_str = pic_str;
    }
    public String getPic_str(){
        return this.pic_str;
    }
    public void setPic(int pic){
        this.pic = pic;
    }
    public int getPic(){
        return this.pic;
    }
    public void setString(List<String> alia){
        this.alia = alia;
    }
    public List<String> getString(){
        return this.alia;
    }

}