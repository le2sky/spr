# Repository Guidelines

## Stacked Pull Requests

- Build pull requests with GitHub Stacks. The bottom pull request targets `main`; every later pull request targets its immediate predecessor branch.
- Submit stacks with `gh stack submit --open` so every pull request is ready for review and can trigger the repository's automatic Codex review.
- After reordering, rebasing, or updating a stack, run `gh stack submit --open` again so remote base branches and pull-request diffs stay synchronized.
- Keep each pull request small and independently reviewable against its declared base branch.

## Pull Request Descriptions

- Every pull request description must include a concise summary of the requested behavior it addresses.
- Describe the implementation scope of the pull request, limited to the changes introduced by that pull request in the stack.
- Include a `DDL changes` section that lists schema changes such as tables, columns, constraints, indexes, and migrations. Explicitly state `None` when there are no DDL changes.

## Code Review Rules

### Stacked pull-request scope

- Review only the changes introduced between the current pull request's declared base and head. Treat ancestor pull requests as context and do not duplicate findings that are confined to an ancestor diff.
- Verify that the current pull request remains correct when applied directly on its declared base. Flag hidden dependencies on later pull requests in the stack.

### Review priorities

- Focus on consequential correctness regressions, unsafe behavior, compatibility breaks, missing error handling, and missing tests for changed behavior.
- When reporting a problem, identify the concrete failure mode and a safe correction or exception.
- Leave formatting, style, and deterministic lint checks to CI.
