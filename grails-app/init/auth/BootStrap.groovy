package auth

class BootStrap {

    def init = { servletContext ->

      // initializing username and userrole so that you can login
      def adminRole = new Role(authority: 'ROLE_ADMIN').save()

      def testUser = new User(username: 'me', password: 'password').save()

      UserRole.create testUser, adminRole

      UserRole.withSession {
        it.flush()
        it.clear()
      }

      assert User.count() == 1
      assert Role.count() == 1
      assert UserRole.count() == 1


      // adds three candidates if there are none
      if(Candidate.count() == 0){
        new Candidate(name: 'Ayush', vote: 0).save(failOnError:true)
        new Candidate(name: 'Kaushal', vote: 0).save(failOnError:true)
        new Candidate(name: 'Milan', vote: 0).save(failOnError:true)
      }

    }
    def destroy = {
    }
}
