# 1. JoinDTO (폼에서 받는 데이터 구조)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JoinDTO {
    private String user_id;        // 아이디
    private String user_name;      // 이름
    private String user_pw;        // 비밀번호
    private String user_pw_check;  // 비밀번호 확인
    private String gender;         // 성별 (M/F)
    private List<String> hobby;    // 취미 (체크박스 다중 선택)
    private boolean machine;       // 기계 여부 (체크박스)
    private Long year;             // 생일 - 년
    private Long month;            // 생일 - 월
    private Long day;              // 생일 - 일
    private MultipartFile up_file; // 업로드 파일
}
```

---

# 2. 컨트롤러에서 DTO 전달

```java
@PostMapping("/member/join_proc")
public String joinProc(
        @ModelAttribute JoinDTO dto,
        @RequestParam("age") int age,
        Model model) {

    // 모델에 DTO와 나이 저장
    model.addAttribute("dto", dto);
    model.addAttribute("age", age);

    return "member/result"; // → templates/member/result.html
}
```

---

# 3. 타임리프 문법

### 기본 출력

```html
<span th:text="${dto.user_id}"></span>   <!-- 아이디 -->
<span th:text="${dto.user_name}"></span> <!-- 이름 -->
```

---

### 문자열 붙이기

```html
<span th:text="${dto.year + '년 ' + dto.month + '월 ' + dto.day + '일'}"></span>
```

---

### 리스트 출력 (hobby)

```html
취미:
<span th:each="h : ${dto.hobby}">
    <span th:text="${h}"></span>
</span>
```

---

### boolean 값 출력 (machine)

```html
기계 여부: <span th:text="${dto.machine}"></span>
```

* 체크했으면 `true`, 아니면 `false` 출력됨

---

### 업로드 파일 정보

```html
업로드 파일명: <span th:text="${dto.up_file.originalFilename}"></span><br>
파일 크기: <span th:text="${dto.up_file.size}"></span> bytes<br>
파일 타입: <span th:text="${dto.up_file.contentType}"></span><br>
```

---

# 4. result.html 전체 예시

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>회원가입 결과</title>
</head>
<body>
<div>
    <h2>가입 결과</h2>
    아이디: <span th:text="${dto.user_id}"></span><br>
    이름: <span th:text="${dto.user_name}"></span><br>
    비밀번호: <span th:text="${dto.user_pw}"></span><br>
    비밀번호 확인: <span th:text="${dto.user_pw_check}"></span><br>
    성별: <span th:text="${dto.gender}"></span><br>
    나이: <span th:text="${age}"></span><br>
    기계 여부: <span th:text="${dto.machine}"></span><br>
    생일: <span th:text="${dto.year + '년 ' + dto.month + '월 ' + dto.day + '일'}"></span><br>

    취미:
    <span th:each="h : ${dto.hobby}">
        <span th:text="${h}"></span>
    </span><br>

    업로드 파일명: <span th:text="${dto.up_file.originalFilename}"></span><br>
    파일 크기: <span th:text="${dto.up_file.size}"></span> bytes<br>
    파일 타입: <span th:text="${dto.up_file.contentType}"></span><br>
</div>
</body>
</html>
```

---

정리

* **DTO 필드명**과 **폼 input name**이 같아야 자동 매핑됨.
* 타임리프는 `${dto.필드명}` 으로 출력.