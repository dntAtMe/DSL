def gitUrl = "https://github.com/dntAtMe/dc"

pipelineJob("DISCORD.VLIFE.master.PIPELINE") {
    concurrentBuild(false)
    description "Builds Discord V-Life project from master branch."
    parameters {
        stringParam('GIT_COMMIT', 'HEAD', 'Commit to build')
    }
    definition {
        cps {
            script(readFileFromWorkspace('pipeline/Jenkinsfile'))
        }
    }
}

job("DISCORD.VLIFE.master.BUILD") {
    scm {
        git {
            remote {
                url('git@github.com:dntAtMe/dc.git')
                credentialsId('dntAtMe2')
            }
        }
    }
    steps {
        shell('./build.sh')
    }
}