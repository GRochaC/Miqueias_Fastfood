package miqueias_fast_food;

public abstract class ItemParaEdicao {
    private static Item item;
    private static int indice;

    public static Item getItem(){
        return item;
    }

    public static void setItem(Item _item){
        item = _item;
    }

    public static int getIndice(){
        return indice;
    }

    public static void setIndice(int _indice){
        indice = _indice;
    }
}
