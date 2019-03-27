public  class MyDeque<E>{
  public E[]data;
  private int size,start,end;
    @SuppressWarnings("unchecked")
  public MyDeque(){
      data = (E[])new Object[100];
      start=0;
      end=0;
      size=0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(E[]ary,int start,int end){
    data=ary;
    this.start=start;
    this.end=end;
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
          if(start>end){
            this.size= data.length-start+end+1;
            return this.size;
          }
          else{

            this.size=end-start+1;
            return this.size;
          }

  }
  public  void  getStart(){
    System.out.println(start);
  }
  public void getEnd(){
    System.out.println(end);
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
      if(size==0){
        data[0]=element;
      }
      else{
      if(size==data.length){
        this.resize();
      }
      if(start!=0 && end==data.length-1){
        data[0]=element;
        size++;
        end=0;
      }
      else{
        data[end+1]=element;
        end++;
      }
    }
      size++;
  }
  public String toString(){
    String result="";

    if(start>end){
      for(int i=start;i<data.length;i++){
        result+=data[i];
      }
    for(int i=0;i<=end;i++){
      result+=data[i];
    }
  }
  else{
    for(int i=start;i<=end;i++){
      result+=data[i];
    }
  }
  return result;
 }
 public static void main(String[]args){
   String[]data={null,null,"c","d"};
   MyDeque<String> test=new MyDeque<String>(data,2,3);
   for(int i=0;i<10;i++){
    test.addLast(""+i);
   }
   test.getStart();
   test.getEnd();
  System.out.println(test);

 }
}
