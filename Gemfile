source 'https://rubygems.org'
gemspec

if ENV['CI']
  # use HTTPS with password on Travis CI
  git_source :github do |repo_name|
    repo_name = "#{repo_name}/#{repo_name}" unless repo_name.include?("/")
    "https://afgalvan:#{ENV.fetch("CI_USER_PASSWORD")}@github.com/#{repo_name}.git"
  end
end

gem 'views', github: "afgalvan/FinalProject-Views"
