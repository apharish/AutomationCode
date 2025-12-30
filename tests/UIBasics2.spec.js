const { test, expect } = require('@playwright/test');

test('UI Basics Test', async ({ page }) => {

    await page.goto('https://jobs.fidelity.com/en/');
    console.log('✅ Title is now updated to:', await page.title());
    await expect(page).toHaveTitle('Find a meaningful career at Fidelity | Fidelity Careers');
    await page.locator("//button[@id ='onetrust-accept-btn-handler']").click();
    await page.locator("button#languageDropdown").click();
    await page.locator("//a[text() = 'English (India)']").click();
    await expect(page.locator("//input[@placeholder='Select Location']")).toBeVisible();
    await page.locator("//input[@placeholder = 'Select Location']").fill('Bangalore');
    await page.locator("//div[@data-value = 'Bangalore']").click();
    await page.locator("//input[@placeholder = 'Search jobs']").fill('Senior Software Engineer in Test');
    await page.locator("//*[text() ='Senior Software Engineer in Test']").click();
    await expect(page.locator("card.card-job")).toBeVisible();
    const countOfOpenings = await page.locator("card.card-job");
    console.log("Total count of openings::" + await countOfOpenings.count());
    
});
