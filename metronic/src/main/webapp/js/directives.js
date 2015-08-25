/***
GLobal Directives
***/

// Route State Load Spinner(used on page or content load)
MetronicApp.directive('ngSpinnerBar', ['$rootScope',
    function($rootScope) {
        return {
            link: function(scope, element, attrs) {
                // by defult hide the spinner bar
                element.addClass('hide'); // hide spinner bar by default

                // display the spinner bar whenever the route changes(the content part started loading)
                $rootScope.$on('$stateChangeStart', function() {
                    element.removeClass('hide'); // show spinner bar
                });

                // hide the spinner bar on rounte change success(after the content loaded)
                $rootScope.$on('$stateChangeSuccess', function() {
                    element.addClass('hide'); // hide spinner bar
                    $('body').removeClass('page-on-load'); // remove page loading indicator
                    Layout.setSidebarMenuActiveLink('match'); // activate selected link in the sidebar menu
                   
                    // auto scorll to page top
                    setTimeout(function () {
                        Metronic.scrollTop(); // scroll to the top on content load
                    }, $rootScope.settings.layout.pageAutoScrollOnLoad);     
                });

                // handle errors
                $rootScope.$on('$stateNotFound', function() {
                    element.addClass('hide'); // hide spinner bar
                });

                // handle errors
                $rootScope.$on('$stateChangeError', function() {
                    element.addClass('hide'); // hide spinner bar
                });
            }
        };
    }
])

// Handle global LINK click
MetronicApp.directive('a', function() {
    return {
        restrict: 'E',
        link: function(scope, elem, attrs) {
            if (attrs.ngClick || attrs.href === '' || attrs.href === '#') {
                elem.on('click', function(e) {
                    e.preventDefault(); // prevent link click for above criteria
                });
            }
        }
    };
});

// Handle Dropdown Hover Plugin Integration
MetronicApp.directive('dropdownMenuHover', function () {
  return {
    link: function (scope, elem) {
      elem.dropdownHover();
    }
  };  
});


MetronicApp.directive('ngFileSelect', ['$rootScope', '$http', function ($rootScope, $http) {
    return function (scope, ele, attr) {
        ele.bind('change', function (e) {
            //上传
            var fn = attr.ngFileSelect;//回调方法，本例为$scope中的upload()方法
            var file = e.target.files[0];
            if (file == undefined) {//没选择文件
                return false;
            }
            var form = new FormData();
            form.append("file", file);
            $rootScope.loading = true;
            $http.post($rootScope.upload.url, form, {
                headers: {
                    'Content-Type': undefined//如果不设置Content-Type,默认为application/json,七牛会报错
                }
            }).success(function (data) {
                $rootScope.loading = false;
                scope[fn](data);//上传回调，将data传到upload方法中
            });
        });
    };
}]);