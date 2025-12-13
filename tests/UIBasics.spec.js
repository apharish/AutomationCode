const { test, expect } = require('@playwright/test');

test('UI Basics Test', async ({ page }) => {

    await page.goto('https://www.youtube.com');

    console.log('✅ Title is now updated to:', await page.title());

    await page.locator("input[name='search_query']").fill('kannada latest songs 2025');
    await page.locator("button.ytSearchboxComponentSearchButton").click();
    
});