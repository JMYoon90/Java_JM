package edu.java.contact.ver02;

import edu.java.contact.ver02.Contact;

// MVC 아키텍쳐에서 Controller의 인터페이스 - 메서드 선언
public interface ContactDao {
    /**
     * 신규 연락처 등록. Argument로 전달된 Contact 객체를 배열에 저장.
     * 
     * @param c 신규 등록할 연락처 정보.
     * @return 배열에 새로운 연락처가 저장되면 1, 그렇지 않으면 0을 리턴.
     */
    int create(Contact c);
    
    /**
     * 전체 전화번호 목록 검색 기능. 모든 연락처 정보가 저장된 배열을 리턴.
     * 
     * @return 연락처 정보가 저장된 배열.
     */
    
    Contact[] read();
    
    /**
     * 인덱스를 사용한 연락처 정보 검색 기능. 배열에서 해당 인덱스의 Contact 객체를 찾아서 리턴.
     * 
     * @param index 연락처 정보를 검색할 인덱스. 0 이상의 정수.
     * @return 배열의 index 위치에 null이 아닌 Contact 객체가 있으면 그 객체를 리턴.
     * index가 배열 범위 밖이거나, 해당 인덱스의 Contact 객체가 없으면 null를 리턴.
     */
    
    Contact read(int index);
    
    /**
     * 연락처 정보 업데이트 기능. 해당 인덱스의 연락처 내용을 수정.
     * @param index 수정할 연락처의 배열 인덱스. 0 이상의 정수.
     * @param name 수정할 이름을 입력.
     * @param phone 수정할 전화번호를 입력.
     * @param password 수정할 새 비밀번호를 입력.
     * @return 비밀번호 수정 성공 시 1, 그렇지 않으면 0을 리턴.
     */
    
    int update(int index, String name, String phone, String email);
    
    
}
