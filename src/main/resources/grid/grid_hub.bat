set current_dir=%cd%
java -jar %current_dir%\selenium-server-standalone-3.141.59.jar -role hub -hubConfig %current_dir%\grid_hub.json
