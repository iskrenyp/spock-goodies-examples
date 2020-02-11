
myToken = '{YOUR_TOKEN_GOES_HERE}'

devReporter {
    // All fields are mandatory to specify
    reportUrl = "http://localhost:8080/job/my_dev_env_job/workspace/build/report.html"
    channelName = 'ipenchev_test'
    userToken = myToken
    environment = 'DEV'
}

stagingReporter {
    reportUrl = "http://localhost:8080/job/my_stage_env_job/workspace/build/report.html"
    channelName = 'staging'
    userToken = myToken
    environment = 'STAGING'
}

// You can actually go and do some specialization within your reporters

backendStagingReporter {
    reportUrl = "http://localhost:8080/job/my_stage_env_backend_job/workspace/build/report.html"
    channelName = 'backend'
    userToken = myToken
    environment = 'STAGING - BACKEND'
}

userAcceptanceReporter {
    reportUrl = "http://localhost:8080/job/my_user_acceptance_job/workspace/build/report.html"
    channelName = 'release'
    userToken = myToken
    environment = 'E2E-UAT'
}