# Repository Guidelines

## Issue-Driven Development

- Before starting implementation, create a GitHub issue that captures the complete requirements for the work, including the objective, expected behavior, acceptance criteria, constraints, and anything explicitly out of scope.
- Create the issue with `.github/ISSUE_TEMPLATE/requirements.md`, preserve its headings, and complete every section. Use `None` when a section has no applicable content.
- Use that issue as the single requirements reference for the entire stacked pull-request series.
- Record the issue number before creating implementation branches or changing code.

## Stacked Pull Requests

- Build pull requests with GitHub Stacks. The bottom pull request targets `main`; every later pull request targets its immediate predecessor branch.
- Submit stacks with `gh stack submit --open` so every pull request is ready for review and can trigger the repository's automatic Codex review.
- After reordering, rebasing, or updating a stack, run `gh stack submit --open` again so remote base branches and pull-request diffs stay synchronized.
- Keep each pull request small and independently reviewable against its declared base branch.
- Reference the requirements issue in every pull request in the stack using `Refs #<issue-number>`. Do not use a closing keyword on intermediate pull requests; use `Closes #<issue-number>` only on the pull request whose merge completes the full requirements.

## Pull Request Descriptions

- Use `.github/pull_request_template.md` for every pull request, preserve its headings, and complete every section. If the submission tool does not populate the template, construct the pull-request body with the same sections before requesting review.
- Every pull request description must include a concise summary of the requested behavior it addresses.
- Describe the implementation scope of the pull request, limited to the changes introduced by that pull request in the stack.
- Include the requirements issue reference for the stacked work.
- Include a `DDL changes` section that lists schema changes such as tables, columns, constraints, indexes, and migrations. Explicitly state `None` when there are no DDL changes.

## Code Review Rules

### Stacked pull-request scope

- Review only the changes introduced between the current pull request's declared base and head. Treat ancestor pull requests as context and do not duplicate findings that are confined to an ancestor diff.
- Verify that the current pull request remains correct when applied directly on its declared base. Flag hidden dependencies on later pull requests in the stack.

### Review priorities

- Focus on consequential correctness regressions, unsafe behavior, compatibility breaks, missing error handling, and missing tests for changed behavior.
- When reporting a problem, identify the concrete failure mode and a safe correction or exception.
- Leave formatting, style, and deterministic lint checks to CI.
