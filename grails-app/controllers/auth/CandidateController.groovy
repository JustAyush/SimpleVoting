package auth

import grails.plugin.springsecurity.annotation.Secured

class CandidateController {
    @Secured('ROLE_ADMIN')
    def index() {
      redirect (action: 'vote')
    }

    @Secured('ROLE_ADMIN')
    def vote(){
      def candidates = Candidate.list()
      [candidates: candidates]
    }

    @Secured('ROLE_ADMIN')
    def saveVote() {
      if(params.id != null){
        def candidates = Candidate.findById(params.id)
        candidates.vote += 1
        candidates.save(flush: true)
      }
      redirect (action: 'vote')
    }
}
