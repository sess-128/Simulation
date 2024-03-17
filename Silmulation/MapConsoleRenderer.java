package Silmulation;

public class MapConsoleRenderer {
    public void render(Map map){
        for (int vert = 15; vert >= 1; vert--) {
            for (int hori = 1; hori <= 10; hori++){
//            for (Hori hori: Hori.values()){
                System.out.println(hori + "||" + String.valueOf(vert));
            }
            
        }
    }
}
