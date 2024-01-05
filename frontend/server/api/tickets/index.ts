
export default defineEventHandler(async (event) => {

    try {
        const response = await fetch(`http://localhost:8080/tickets`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('no available data');
        }

        return response
    } catch (error) {
        console.error('Error during fetch:', error);
    }

})