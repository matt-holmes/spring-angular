angular.module("app",[]).config(function ($httpProvider) {
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    }).controller("home", function($http) {
        var self = this;
        self.refresh = function(){
            $http.get("/greeting").then(function(response){
                if(response.data) {
                    self.greeting = response.data;
                    self.hide = true;
                }
            });
        };

        self.refresh();
        self.credentials = {};
        self.login = function () {
            $http.get('/greeting', {
                headers : { authorization : "Basic "
                + btoa(self.credentials.username
                    + ":" + self.credentials.password)
                }}).then( function (response) {
                    self.greeting = response.data;
                    self.hide = true;
            })
        };

        self.logout = function() {
            $http.post("/logout").then(function() {
                self.hide = false;
                self.greeting = {};
            });
        };
});
