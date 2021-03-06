package com.example.felipe.restapigithub;

import com.example.felipe.restapigithub.model.Repository;
import com.example.felipe.restapigithub.rest.GitHubService;

import org.junit.Test;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertTrue;

/**
 * Created by Felipe on 10/01/2017.
 */

public class RetrofitUnitTest {

    @Test
    public void mockWebServer() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("").toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mockWebServer.enqueue(new MockResponse().setBody("{\n" +
                "  \"total_count\": 2685150,\n" +
                "  \"incomplete_results\": false,\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"id\": 7508411,\n" +
                "      \"name\": \"RxJava\",\n" +
                "      \"full_name\": \"ReactiveX/RxJava\",\n" +
                "      \"owner\": {\n" +
                "        \"login\": \"ReactiveX\",\n" +
                "        \"id\": 6407041,\n" +
                "        \"avatar_url\": \"https://avatars.githubusercontent.com/u/6407041?v=3\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/ReactiveX\",\n" +
                "        \"html_url\": \"https://github.com/ReactiveX\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/ReactiveX/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/ReactiveX/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/ReactiveX/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/ReactiveX/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/ReactiveX/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/ReactiveX/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/ReactiveX/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/ReactiveX/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/ReactiveX/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"private\": false,\n" +
                "      \"html_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
                "      \"description\": \"RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.\",\n" +
                "      \"fork\": false,\n" +
                "      \"url\": \"https://api.github.com/repos/ReactiveX/RxJava\",\n" +
                "      \"forks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/forks\",\n" +
                "      \"keys_url\": \"https://api.github.com/repos/ReactiveX/RxJava/keys{/key_id}\",\n" +
                "      \"collaborators_url\": \"https://api.github.com/repos/ReactiveX/RxJava/collaborators{/collaborator}\",\n" +
                "      \"teams_url\": \"https://api.github.com/repos/ReactiveX/RxJava/teams\",\n" +
                "      \"hooks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/hooks\",\n" +
                "      \"issue_events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/events{/number}\",\n" +
                "      \"events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/events\",\n" +
                "      \"assignees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/assignees{/user}\",\n" +
                "      \"branches_url\": \"https://api.github.com/repos/ReactiveX/RxJava/branches{/branch}\",\n" +
                "      \"tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/tags\",\n" +
                "      \"blobs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/blobs{/sha}\",\n" +
                "      \"git_tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/tags{/sha}\",\n" +
                "      \"git_refs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/refs{/sha}\",\n" +
                "      \"trees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/trees{/sha}\",\n" +
                "      \"statuses_url\": \"https://api.github.com/repos/ReactiveX/RxJava/statuses/{sha}\",\n" +
                "      \"languages_url\": \"https://api.github.com/repos/ReactiveX/RxJava/languages\",\n" +
                "      \"stargazers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/stargazers\",\n" +
                "      \"contributors_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contributors\",\n" +
                "      \"subscribers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscribers\",\n" +
                "      \"subscription_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscription\",\n" +
                "      \"commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/commits{/sha}\",\n" +
                "      \"git_commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/commits{/sha}\",\n" +
                "      \"comments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/comments{/number}\",\n" +
                "      \"issue_comment_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/comments{/number}\",\n" +
                "      \"contents_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contents/{+path}\",\n" +
                "      \"compare_url\": \"https://api.github.com/repos/ReactiveX/RxJava/compare/{base}...{head}\",\n" +
                "      \"merges_url\": \"https://api.github.com/repos/ReactiveX/RxJava/merges\",\n" +
                "      \"archive_url\": \"https://api.github.com/repos/ReactiveX/RxJava/{archive_format}{/ref}\",\n" +
                "      \"downloads_url\": \"https://api.github.com/repos/ReactiveX/RxJava/downloads\",\n" +
                "      \"issues_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues{/number}\",\n" +
                "      \"pulls_url\": \"https://api.github.com/repos/ReactiveX/RxJava/pulls{/number}\",\n" +
                "      \"milestones_url\": \"https://api.github.com/repos/ReactiveX/RxJava/milestones{/number}\",\n" +
                "      \"notifications_url\": \"https://api.github.com/repos/ReactiveX/RxJava/notifications{?since,all,participating}\",\n" +
                "      \"labels_url\": \"https://api.github.com/repos/ReactiveX/RxJava/labels{/name}\",\n" +
                "      \"releases_url\": \"https://api.github.com/repos/ReactiveX/RxJava/releases{/id}\",\n" +
                "      \"deployments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/deployments\",\n" +
                "      \"created_at\": \"2013-01-08T20:11:48Z\",\n" +
                "      \"updated_at\": \"2017-01-09T16:29:12Z\",\n" +
                "      \"pushed_at\": \"2017-01-09T21:27:46Z\",\n" +
                "      \"git_url\": \"git://github.com/ReactiveX/RxJava.git\",\n" +
                "      \"ssh_url\": \"git@github.com:ReactiveX/RxJava.git\",\n" +
                "      \"clone_url\": \"https://github.com/ReactiveX/RxJava.git\",\n" +
                "      \"svn_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
                "      \"homepage\": \"\",\n" +
                "      \"size\": 35636,\n" +
                "      \"stargazers_count\": 20297,\n" +
                "      \"watchers_count\": 20297,\n" +
                "      \"language\": \"Java\",\n" +
                "      \"has_issues\": true,\n" +
                "      \"has_downloads\": true,\n" +
                "      \"has_wiki\": true,\n" +
                "      \"has_pages\": true,\n" +
                "      \"forks_count\": 3579,\n" +
                "      \"mirror_url\": null,\n" +
                "      \"open_issues_count\": 45,\n" +
                "      \"forks\": 3579,\n" +
                "      \"open_issues\": 45,\n" +
                "      \"watchers\": 20297,\n" +
                "      \"default_branch\": \"2.x\",\n" +
                "      \"score\": 1.0\n" +
                "    }\n" +
                "  ]\n" +
                "}"));
        GitHubService service = retrofit.create(GitHubService.class);
        Call<Repository> repositories = service.getRepositories();
        assertTrue(repositories.execute() != null);
        mockWebServer.shutdown();
    }
}
