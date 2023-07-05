package ex07string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class E02StringMethod4 {

	public static void main(String[] args) {

		/*
		시나리오] 주민등록번호를 이용하여 성별을 판단하는
		프로그램을 charAt()을 이용해서 작성하시오.
		190419-3000000 => 남자
		190419-4000000 => 여자
]		*/
		Scanner scanner = new Scanner(System.in);

        System.out.print("주민등록번호를 입력하세요: ");
        String residentRegistrationNumber = scanner.nextLine();

        char genderCode = residentRegistrationNumber.charAt(6);
        int genderNumber = Character.getNumericValue(genderCode);

        if (genderNumber % 2 == 0) {
            System.out.println("여성입니다.");
        } else {
            System.out.println("남성입니다.");
            System.out.println();
        }
    }

		
		/*
		시나리오] 해당 문자열이 이메일 형식인지 검사하는
		프로그램을 contains()를 이용해서 작성하시오.
		hong@daum.net => 이메일형식임
		not@naver => 이메일형식이아님
		*/
	

	
	
		/*
		시나리오]주민등록번호로 성별을 구분하는 프로그램을 indexOf()를
		이용해서 작성하시오.
		*/	
	public class GenderIdentifier {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("주민등록번호를 입력하세요 (ex. 000000-0000000): ");
	        String jumin = scanner.nextLine();
	        
	        int index = jumin.indexOf('-');
	        if (index == -1) {
	            System.out.println("잘못된 주민등록번호 형식입니다.");
	            return;
	        }
	        
	        String genderNumber = jumin.substring(index + 1, index + 2);
	        int gender = Integer.parseInt(genderNumber);
	        
	        if (gender % 2 == 0) {
	            System.out.println("성별: 여자");
	        } else {
	            System.out.println("성별: 남자");
	        }
	    }
	}	
	
	
	
		/*
		시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을
		작성하시오. 
		파일명 : my.file.images.jpg
		*/
	public class FileExtensionExtractor {
	    public static void main(String[] args) {
	        String filename = "my.file.images.jpg";
	        String extension = extractFileExtension(filename);
	        System.out.println("Extension: " + extension);
	    }

	    public static String extractFileExtension(String filename) {
	        int dotIndex = filename.lastIndexOf(".");
	        if (dotIndex == -1) {
	            return ""; // 파일명에 확장자가 없는 경우
	        } else {
	            return filename.substring(dotIndex + 1);
	        }
	    }
	}
	
	
	}

