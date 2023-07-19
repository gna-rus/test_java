import java.util.HashMap;
import java.util.LinkedList;

class ClassOfStore {
    private int count;
    private int num;
    private String nameToy; // название игрушки
    private int rndQuantityInStock;
   
   public ClassOfStore (int count, int num, String  nameToy, int rndQuantityInStock)
  {
    this.count = count;
    this.num = num;
    this.nameToy = nameToy;
    this.rndQuantityInStock = rndQuantityInStock;
  }
  
  public int getCount ()
  {
    return count;
  }

  public void setCount (int count)
  {
    this.count = count;
  }
  
  
  public int getNum ()
  {
    return num;
  }

  public void setNum (int num)
  {
    this.num = num;
  }
  
  public String GetNameToy ()
  {
    return nameToy;
  }

  public void SetNameToy (String nameToy)
  {
    this.nameToy = nameToy;
  }
  
    public int getQuantity ()
  {
    return rndQuantityInStock;
  }

  public void setQuantity (int rndQuantityInStock)
  {
    this.rndQuantityInStock = rndQuantityInStock;
  }

    @Override
    public String toString() {
        return ""
                + "id = " + count
                + ", weight = " + num
                + ", Name = " + nameToy
                + ", quantity_in_stock = " + rndQuantityInStock  + '.';
    }
    
    
    public LinkedList toLink() {
    LinkedList<String> toLinkToyStore = new LinkedList<>();
    toLinkToyStore.add(nameToy);
    return toLinkToyStore;
    }
}
