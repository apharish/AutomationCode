const { test, expect } = require('@playwright/test');

test('UI Basics Test', async ({ page }) => {

    await page.goto('https://www.google.com');
    console.log('✅ Title is now updated to:', await page.title());
    await expect(page).toHaveTitle('Google');
});
