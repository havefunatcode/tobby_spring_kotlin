### 2024.01.03 수정사항
- NoArg Annotation 제거
  - NoArg Plugin을 정확하게 알고 사용하지 않음.
  - NoArg Plugin의 경우 Reflection을 사용한 No Arg를 제공하는 것인데, Spring을 쓰지 않고 진행하는 초반 코드에서는 NoArg Plugin의 기능을 사용할 필요가 없음.
- Test Code 수정
  - DB정보를 암호화하여 관리하고 싶었기 때문에 TestConfig는 Spring을 사용함.
  - 책과는 결이 다르지만 DB 정보를 노출시키고 싶지 않았음.
