<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta name="layout" content="main" charset="utf-8">
    <title> Vote </title>
  </head>
  <body>
    
      <div class="container" style="width:50%;">
      <g:form controller="Candidate" action="saveVote">
      <table class="table table-striped">
      <thead>
        <tr>
          <th> <h3> Check to Vote </h3> </th>
          <th> <h3> Candidate's Name </h3> </th>
          <th> <h3> Votes </h3> </th>
        </tr>
      </thead>
      <tbody>
        <g:each var="i" in="${candidates}">
        <tr>
          <td><g:radio name="id" value='${i.id}'/></td> <td><h5> ${i.name} </h5></td> <td><h5> ${i.vote} </h5></td>
        </g:each>
        </tr>
      </tbody>
      </table>
        <g:actionSubmit action="saveVote" value="Cast vote" class="btn btn-primary"/>
      </g:form>
      </div>

  </body>
</html>
