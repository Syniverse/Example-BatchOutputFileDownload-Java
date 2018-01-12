# Example-BatchOutputFileDownload-Java
Java example for automatic detection and download of BatchAutomation job output files.

## Prerequisites

An SDC account is required. A general knowledge of how to set up and run BatchAutomation jobs is required. Details for both of these can be found here https://github.com/Syniverse/QuickStart-BatchAutomation-Java

## Setup
To run this sample as-is, the following are required
- JDK 8
- Eclipse or other IDE 
- Maven 
- Publicly accessible web container (must host a service to receive job completion notifications)

Importing this project into Eclipse as "Existing Maven Projects" should generate needed project metadata and resolve dependencies (assuming automatic build preferences were not disabled in the workspace).

This sample covers all operations required to capture job completion notifications and download the related output.
- Start a web service to receive ESS event notifications
- Harvest data from the notification to retrieve output files from MSS
- Download and save files locally

Some configurations will need to be set to specify some user specific data, and define which sample job type is to be run. All of this is done in src/main/resources/application.properties

__user.sdc.bearer-token__ - This value is set as the Authentication header in the sample http requests. A valid SDC bearer token must be set here.


# Run It

com.syniverse.eis.aba.sample.controllers.EssEventController defines the service endpoint. Once started, invocation is performed via POST <host>/aba-sample-outputdownload/ess/event-delivery

The URL to this service will need to be set as the "address" value of the Delivery Configuration set up in the prerequisite steps. Once that's done, ESS will dispatch notifications to this sample service. If access to a publicly visible web server is not possible, something like https://putsreq.com can be used as a workaround. The Delivery Configuration address can be set to a putsreq site, then notifications can be manually copied from the putsreq history and used to manually invoke a local instance of this sample service.

When a notification event of type "aba_job_completed" is received by this service, the output files associated with the completed job are downloaded and placed under /aba-sample-output
