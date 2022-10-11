package edu.java.contact.ver02;

// MVC 아키텍쳐에서 Controller (구현) 클래스
public class ContactDaoImpl implements ContactDao{
    // Contact 객체를 저장할 배열의 최대 크기
    // Contact 객체들을 저장할 배열
    // 배열에 저장될 Contact 객체의 개수. Contact 객체가 배열에 저장될 때마다 1씩 증가.
    
    public static final int MAX_LENGTH = 3;
    private Contact[] contactList = new Contact[MAX_LENGTH];
    private int count = 0;
    
    public int getCount() {
        return count;
    }
    
    // Controller 클래스는 Singleton으로 설계: 1) + 2) + 3)
    // 1) 자기자신 타입의 private static인 변수 선언
    // 2) private 생성자
    // 3) 자기 자신 타입을 리턴하는 public static 메서드 정의.
        
    private static ContactDaoImpl instance = null;
    private ContactDaoImpl() {}
    public static ContactDaoImpl getInstance() {
        if(instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }
    
    
    @Override
    public int create(Contact c) {
        if(count >= MAX_LENGTH) {
            return 0;
        }        
        contactList[count] = c;
        count++;
        return 1;
    }
    @Override
    public Contact[] read() {
        Contact[] contacts = new Contact[count];
        for(int i= 0; i < count; i++) {
            contacts[i] = contactList[i];
        }
        
        return contacts;
    }
    
    @Override
    public Contact read(int index) {
        if(index >=0 && index < MAX_LENGTH) {
            return contactList[index];    
        } else {
            return null;
        }
        
    }
    @Override
    public int update(int index, String name, String phone, String email) {
        if (index >= 0 && index < count) {
            contactList[index].setName(name);
            contactList[index].setPhone(phone);
            contactList[index].setEmail(email);
            return 1;   
        } else {
            return 0;
        }

    }
}
