import java.util.Arrays;
import java.util.NoSuchElementException;
public  class MyDeque<E>{
  private E[]data;
  private int size,start,end;
    @SuppressWarnings("unchecked")
  public MyDeque(){
      data = (E[])new Object[100];
      start=0;
      end=0;
      size=this.size();
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int startingCapacity){
   data = (E[])new Object[startingCapacity];
    start=0;
    end=0;
    size=0;
  }
  public int size(){ // works
     return this.size;

  }
  @SuppressWarnings("unchecked")
  private void resize(){ // seems to work,not very thoroughly checked though
     E[]result;
      result = (E[])new Object[data.length*2];
    if(start>end){
      int index=0;
      for(int  i=start;i<data.length;i++){
        result[index]=data[i];
        index++;
      }
      for(int i=0;i<=end;i++){
        result[index]=data[i];
        index++;
      }
      this.data=result;
      start=0;
      end=index-1; // end should be fine here
    }
    else{
      int index=0;
      for(int i=start;i<=end;i++){
        result[index]=data[i];
        index++;
      }
      this.data=result;
      start=0;
      end=index-1;
    }
  }
  public void addLast(E element){// thorougly checked{
    if(element==null){
      throw new NullPointerException();
    }
      else{
      if(size==data.length){
        this.resize();
      }
      if(size==0){
        data[0]=element;
      }
      else if(start!=0 && end==data.length-1){
        data[0]=element;
        end=0;
      }
      else{
        data[end+1]=element;
        end++;
      }
    }
      size++;
  }
  public void addFirst(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(size==data.length){
      this.resize();
    }
    if(size==0){
      data[0]=element;
      size++;
    }
    else if(start==0){
      data[data.length-1]=element;
      start=data.length-1;
      size++;
    }
    else{
      data[start-1]=element;
      start=start-1;
      size++;
    }
  }
  public String toString(){
    String result="{";
    if(size==0){
      return "{}";
    }
    if(start>end){
      for(int i=start;i<data.length;i++){
        result+=data[i]+" ";
      }
    for(int i=0;i<=end;i++){
      result+=data[i]+" ";
    }
  }
  else{
    for(int i=start;i<=end;i++){
      result+=data[i];
    }
  }
  return result+"}";
 }
 public  E removeFirst(){
   if(size==0){
     throw new NoSuchElementException();
   }
   E result =data[start];
   if(start==end){
     data[start]=null;;
     start=0;
     end=0;
     size--;
   }
   else if (start==data.length){
     data[start]=null;
     start=0;
     size--;
   }
   else{
     data[start]=null;
     start=start+1;
     size--;
   }
   return result;
 }
 public  E getFirst(){
   if(size==0){
     throw new NoSuchElementException();
   }
   return data[start];
 }
 public  E getLast(){
   if(size==0){
     throw new NoSuchElementException();
   }
   return data[end];
 }
 public E removeLast(){
   if(size==0){
     throw new NoSuchElementException();
   }
   E result=data[end];
   if(end==start){
     data[end]=null;
     start=0;
     end=0;
     size--;
   }
  else if(end==0){
     data[end]=null;
     end=data.length;
     size--;
   }
   else{
     data[end]=null;
     end--;
     size--;
   }
   return result;
 }
 

}
