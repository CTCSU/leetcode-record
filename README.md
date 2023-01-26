# Sync up leet code problem processing

This is my personal repo to record leet code problems. I've tried to use repetition methodology which means I would resolve those problems several times.
So I would like to record those attempts in this repository.

Currently I'm using vscode and the plugin to write the code with intelligent auto completion and it's easier to debug.

In the mean time, I'm using the extension [leetcode-vscode](https://marketplace.visualstudio.com/items?itemName=ccagml.vscode-leetcode-problem-rating) to generate the file name in a way I prefer.

## My leetcode-vscode setting

```json
	"leetcode-problem-rating.defaultLanguage": "java",
	"leetcode-problem-rating.endpoint": "leetcode-cn",
	"leetcode-problem-rating.filePath": {
		"default": {
			// file name
			"filename": "${id}.${kebab-case-name}.${ext}",
			// relative folder path
			"folder": ""
		},
		"java": {
			"filename": "${id}.${kebab-case-name}-${yyyymmdd}.${ext}",
			"folder": "${difficulty}/java"
		}
	},
	"leetcode-problem-rating.hint.commandShortcut": false,
	"leetcode-problem-rating.hint.commentDescription": false,
	"leetcode-problem-rating.hint.configWebviewMarkdown": false,
	"leetcode-problem-rating.useEndpointTranslation": false,
	"leetcode-problem-rating.workspaceFolder": "d:\\.leetcode",

```
