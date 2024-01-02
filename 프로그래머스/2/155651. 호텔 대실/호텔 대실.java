import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        List<Room> list = new ArrayList<>();
        PriorityQueue<Book> pq = new PriorityQueue<>((o1,o2) -> o1.start - o2.start);
        list.add(new Room());
        for(String[] s : book_time){
            String[] start = s[0].split(":");
            int startInt = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = s[1].split(":");
            int endInt = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            pq.offer(new Book(startInt, endInt));
        }
        
        while(!pq.isEmpty()){
            Book book = pq.poll();
            list.forEach(room -> room.checkOut(book.start));
            if(list.stream().filter(room -> room.status.equals(Status.EMPTY)).count() > 0){
                for(int i = 0; i < list.size(); i++){
                    Room room = list.get(i);
                    if(room.status.equals(Status.EMPTY)) {
                        room.checkIn(book.end);
                        break;
                    }
                }
            }else{
                Room newRoom = new Room();
                newRoom.checkIn(book.end);
                list.add(newRoom);
            }
            
        }
        return list.size();
    }
}

class Book {
    int start;
    int end;
    
    Book(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Room {
    Status status;
    int time;
    
    Room(){
        status = Status.EMPTY;
    }
    
    public void checkOut(int time){
        if(this.time <= time) status = Status.EMPTY;
    }
    
    public void checkIn(int time){
        status = Status.USE;
        this.time = time;
    }
}

enum Status {
    EMPTY, USE;
}