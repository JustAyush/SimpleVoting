package auth

class Candidate {

    String name
    Integer vote

    static constraints = {
      // name [nullable: false, unique: true]
    }
}
