module.exports = function(grunt) {
    console.log("I'm alive");
    grunt.initConfig({
            pkg: grunt.file.readJSON('package.json'),
//            karma: {
//                unit: {
//                    options: {
//                        files: ['test/**/*.js'],
//                        frameworks: ['jasmine'],
//                        singleRun: true,
//                        browsers: ['PhantomJS']
//                    }
//                }
//            },
            uncss: {
              dist: {
                files: {
                  'dist/css/tidy.css': []
                }
              }
            }
            gruntMavenProperties: grunt.file.readJSON('grunt-maven.json'),
            mavenPrepare: {
                options: {
                    resources: ['**']
                },
                dev: {}
            },
            mavenDist: {
                options: {
                    warName: 'ROOT',
                    deliverables: ["<%= pkg.name %>*.js", "*.js", "!js/test/**"]
                },
                dev: {}
            },
            watch: {
                files: ["<%= gruntMavenProperties.filesToWatch %>"],
                tasks: ['default']
            }
        });

        grunt.loadNpmTasks('grunt-maven');
//        grunt.loadNpmTasks('grunt-contrib-watch');
//        grunt.loadNpmTasks('grunt-karma');
        grunt.loadNpmTasks('grunt-uncss');

        grunt.registerTask('default', ['mavenPrepare', 'mavenDist']);
//        grunt.registerTask('test', ['karma']);
};